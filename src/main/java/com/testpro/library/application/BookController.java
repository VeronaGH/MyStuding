package com.testpro.library.application;

import com.testpro.library.application.dto.BookDTO;
import com.testpro.library.domain.service.BookService;
import com.testpro.library.domain.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for processing incoming json contains Book data
 */
@Controller
@RequestMapping(value = "/library/v1/books")
public class BookController {

    public IdService idService;
    public BookService bookService;

    @Autowired
    public BookController(IdService idService, BookService bookService) {
        this.idService = idService;
        this.bookService = bookService;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case library, name, author, year of publishing has came.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeBook(@RequestBody final BookDTO bookDTO) {
        if ((bookDTO.getLib() != null) & (bookDTO.getAuthor() != null) & (bookDTO.getName() != null) & (bookDTO.getYearPublish() != 0)) {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    new BookDTO().convertToBookDTO(bookService.storeBook(bookDTO.convertToBook())));
        } else return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(bookDTO);
    }

    /**
     * This method delete all documents which contains incoming  name, surname and date
     */

    /**
     * This method return all documents which contains appropriate name or surname or return all
     * documents, if parameters not defined.
     */

    /**
     * Thise method updates appropriate entity in DB if find single entity by name, surname and yearOfBirth
     * else returns the list of entity
     */
}
