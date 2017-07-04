package com.testpro.library.application;

import com.testpro.library.application.convertots.BookConverter;
import com.testpro.library.application.dto.*;
import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for processing incoming json contains Book data
 */
@RestController
@RequestMapping(value = "/library/v1/books")
public class BookController {
    private final BookService bookService;
    private final BookConverter bookConverter;

    @Autowired
    public BookController(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case library, name, author, year of publishing has came.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeBook(@RequestBody final BookDTO bookDTO) {
        if ((bookDTO.getLibraryDTO() != null) & (bookDTO.getAuthorDTO() != null) & (bookDTO.getName() != null) & (bookDTO.getYearPublish() != 0)) {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    bookConverter.convertToBookDTO(bookService.storeBook(bookConverter.convertToBook(bookDTO))));
        } else
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(bookDTO);
    }

    /**
     * This method delete all documents which contains incoming  name, surname and date
     */

    /**
     * This method return all documents which contains appropriate data or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchBook(
            @RequestParam(value = "library", required = false) final LibraryDTO libraryDTO,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "author", required = false) AuthorDTO authorDTO,
            @RequestParam(value = "genre", required = false) GenreDTO genreDTO,
            @RequestParam(value = "publishingHouse", required = false) PublishingHouseDTO publishingHouseDTO,
            @RequestParam(value = "yearPublish", required = false) int yearPublish,
            @RequestParam(value = "bestSeller", required = false) Boolean bestSeller,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "state", required = false) Book.State state) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                null);
    }

    /**
     * This method updates appropriate entity in DB if find single entity by name, surname and yearOfBirth
     * else returns the list of entity
     */
}
