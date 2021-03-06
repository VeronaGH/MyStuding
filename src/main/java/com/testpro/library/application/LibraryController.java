package com.testpro.library.application;

import com.testpro.library.application.convertots.LibraryConverter;
import com.testpro.library.application.dto.LibraryDTO;
import com.testpro.library.domain.model.Library;
import com.testpro.library.domain.service.IdService;
import com.testpro.library.domain.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for processing incoming json contains Library data
 */
@RestController
@RequestMapping("/library/v1/libraries")
public class LibraryController {

    private LibraryService libraryService;
    private IdService idService;

    @Autowired
    public LibraryController(LibraryService libraryService, IdService idService) {
        this.libraryService = libraryService;
        this.idService = idService;
    }

    /**
     * Save method of controller, asses method 'POST'
     *
     * @param libraryDTO class
     * @return libraryDTO
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeLibrary(@RequestBody final LibraryDTO libraryDTO) {
        if ((libraryDTO.getName() != null) && (libraryDTO.getAddress() != null)) {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    new LibraryConverter().convertToLibraryDTO(libraryService.storeLibrary(new Library(
                            idService.incIdLibrary(),
                            libraryDTO.getName(),
                            libraryDTO.getAddress(),
                            libraryDTO.getQuantityWorkers()))));
        }
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(libraryDTO);
    }

    /**
     * This method delete all documents which contains incoming  name and address
     *
     * @param libraryDTO class
     * @return List<LibraryDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteLibrary(@RequestBody final LibraryDTO libraryDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new LibraryConverter().convertToLibraryDTO(libraryService.deleteLibrary(new LibraryConverter().convertToLibrary(libraryDTO))));
    }

    /**
     * This method return all documents which contains appropriate name or address or return all
     * documents, if parameters not defined.
     *
     * @return List<LibraryDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchLibrary(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "quantityWorkers", required = false) String quantityWorkers) {
        if (quantityWorkers == null) {
            quantityWorkers = "0";
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new LibraryConverter().convertToLibraryDTOList(libraryService.findLibrary(
                        new Library(0, name, address, Integer.parseInt(quantityWorkers)))));
    }


    /**
     * This method updates appropriate entity in DB if find single entity by name, else returns the list of entity
     *
     * @param libraryDTO class
     * @return List<LibraryDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateLibrary(@RequestBody final LibraryDTO libraryDTO) {
        List<Library> libraryList = libraryService.updateLibrary(new LibraryConverter().convertToLibrary(libraryDTO));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new LibraryConverter().convertToLibraryDTOList(libraryList));
    }
}
