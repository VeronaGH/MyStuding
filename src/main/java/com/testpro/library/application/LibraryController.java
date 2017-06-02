package com.testpro.library.application;

import com.testpro.library.application.dto.LibraryDTO;
import com.testpro.library.domain.model.Library;
import com.testpro.library.domain.service.IdService;
import com.testpro.library.domain.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for processing incoming json contains Library data
 */
@RestController
@RequestMapping("/library/v1/libraries")
public class LibraryController {

    private LibraryService libraryService;
    private IdService idService;

    Library library;

    @Autowired
    public LibraryController(LibraryService libraryService, IdService idService) {
        this.libraryService = libraryService;
        this.idService = idService;
    }

    /**
     * Save method of controller, asses method 'POST'
     *
     * @param libraryDTO
     * @return libraryDTO
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeLibrary(@RequestBody final LibraryDTO libraryDTO) {

        library = libraryService.saveLibrary(new Library(
                idService.incIdLibrary(),
                libraryDTO.getName(),
                libraryDTO.getAddress(),
                libraryDTO.getQuantityWorkers()));

        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                new LibraryDTO(
                        library.getName(),
                        library.getAddress(),
                        library.getQuantityWorkers()));
    }

    /**
     * This method delete all documents which contains incoming  name and address
     *
     * @param libraryDTO
     * @return List<Library>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteLibrary(@RequestBody final LibraryDTO libraryDTO) {

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                libraryService.deleteLibrary(new Library(
                        0,
                        libraryDTO.getName(),
                        libraryDTO.getAddress(),
                        libraryDTO.getQuantityWorkers())));
    }

    /**
     * This method return all documents at the library with asses method 'GET'
     *
     * @return List<Library>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readLibrary() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                libraryService.reedLibrary());
    }

    /**
     * This method return all documents which contains appropriate name or address
     *
     * @param libraryDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity searchLibrary(@RequestBody final LibraryDTO libraryDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                libraryService.findLibraryByNameOrAdress(new Library(
                        0,
                        libraryDTO.getName(),
                        libraryDTO.getAddress(),
                        libraryDTO.getQuantityWorkers())));
    }


    /**
     * Thise method updates appropriate entity in DB if find single entity by name, else returns the list of entity
     * @param libraryDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity updateLibrary(@RequestBody final LibraryDTO libraryDTO){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                libraryService.updateLibrary(new Library(
                        0,
                        libraryDTO.getName(),
                        libraryDTO.getAddress(),
                        libraryDTO.getQuantityWorkers())));
    }
}
