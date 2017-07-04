package com.testpro.library.application;

import com.testpro.library.application.convertots.ReaderConverter;
import com.testpro.library.application.dto.ReaderDTO;
import com.testpro.library.domain.model.Reader;
import com.testpro.library.domain.service.IdService;
import com.testpro.library.domain.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for processing incoming json contains Reader data
 */
@RestController
@RequestMapping(value = "/library/v1/readers")
public class ReaderController {

    private ReaderService readerService;
    private IdService idService;

    @Autowired
    public ReaderController(ReaderService readerService, IdService idService) {
        this.readerService = readerService;
        this.idService = idService;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case name, surname and yearOfBirth has came and are unique.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeReader(@RequestBody ReaderDTO readerDTO) {
        if ((readerDTO.getName() != null) && (readerDTO.getSurname() != null)) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                    new ReaderConverter().convertToReaderDTO(readerService.storeReader(new Reader(
                            idService.incIdReader(),
                            readerDTO.getName(),
                            readerDTO.getSurname(),
                            readerDTO.getAddress(),
                            readerDTO.getState()))));
        } else {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(readerDTO);
        }
    }

    /**
     * This method delete all documents which contains incoming  name and  surname
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteReader(@RequestBody ReaderDTO readerDTO) {
        if ((readerDTO.getName() != null) && (readerDTO.getSurname() != null)) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                    new ReaderConverter().convertToReaderDTO(readerService.deleteReader(new ReaderConverter().convertToReader(readerDTO))));
        } else {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(readerDTO);
        }
    }

    /**
     * This method return all documents which contains appropriate name or surname or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findReader(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "state", required = false) Reader.State state) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new ReaderConverter().convertToReaderDTOList(readerService.findReader(
                        new Reader(0, name, surname, address, state))));
    }

    /**
     * This method updates appropriate entity in DB if find single entity by name and surname
     * else returns nothing.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateReader(@RequestBody final ReaderDTO readerDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new ReaderConverter().convertToReaderDTO(readerService.updateReader(new ReaderConverter().convertToReader(readerDTO))));
    }
}
