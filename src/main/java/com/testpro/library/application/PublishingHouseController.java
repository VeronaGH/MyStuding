package com.testpro.library.application;

import com.testpro.library.application.convertots.PublishingHouseConverter;
import com.testpro.library.application.dto.PublishingHouseDTO;
import com.testpro.library.domain.model.PublishingHouse;
import com.testpro.library.domain.service.IdService;
import com.testpro.library.domain.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for processing incoming json contains PublishingHouse data
 */
@RestController
@RequestMapping(value = "/library/v1/publishingHouse")
public class PublishingHouseController {
    private IdService idService;
    private PublishingHouseService publishingHouseService;

    @Autowired
    public PublishingHouseController(IdService idService, PublishingHouseService publishingHouseService) {
        this.idService = idService;
        this.publishingHouseService = publishingHouseService;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case name, and address has came and are unique.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storePublishingHouse(@RequestBody PublishingHouseDTO publishingHouseDTO) {
        if ((publishingHouseDTO.getName() != null) && (publishingHouseDTO.getAddress() != null)) {
            PublishingHouse publishingHouse = new PublishingHouse(
                    idService.incIdPublishingHouse(),
                    publishingHouseDTO.getName(),
                    publishingHouseDTO.getAddress(),
                    publishingHouseDTO.getPhone(),
                    publishingHouseDTO.getContact());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                    new PublishingHouseConverter().convertToPublishHouseDTO(publishingHouseService.storePublishingHouse(publishingHouse)));
        }
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(
                publishingHouseDTO);
    }

    /**
     * This method delete all documents which contains incoming  name and address, return entity if found appropriate
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deletePiblishHouse(@RequestBody PublishingHouseDTO publishingHouseDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new PublishingHouseConverter().convertToPublishingHouseDTOList(publishingHouseService.deletePublishingHouse(
                        new PublishingHouseConverter().convertToPublishHouse(publishingHouseDTO))));
    }

    /**
     * This method return all documents which contains appropriate name or address or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchPublishingHouse(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "contact", required = false) String contact) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new PublishingHouseConverter().convertToPublishingHouseDTOList(publishingHouseService.findPublishingHouse(
                        new PublishingHouse(0, name, address, phone, contact))));
    }

    /**
     * This method updates appropriate entity in DB if find single entity by name and address
     * else returns the list of entity
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePublishingHouse(@RequestBody PublishingHouseDTO publishingHouseDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new PublishingHouseConverter().convertToPublishHouseDTO(publishingHouseService.updatePublishingHouse(
                        new PublishingHouseConverter().convertToPublishHouse(publishingHouseDTO))));
    }
}
