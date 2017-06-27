package com.testpro.library.application;

import com.testpro.library.application.dto.AuthorDTO;
import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.service.AuthorService;
import com.testpro.library.domain.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for processing incoming json contains Author data
 */
@Controller
@RequestMapping(value = "/library/v1/authors")
public class AuthorController {

    private AuthorService authorService;
    private IdService idService;

    Author author;

    @Autowired
    public AuthorController(AuthorService authorService, IdService idService) {
        this.authorService = authorService;
        this.idService = idService;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case name, surname and yearOfBirth has came.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity storeAuthor(@RequestBody final AuthorDTO authorDTO) {
        if (authorDTO.getName() != null && authorDTO.getSurname() != null && authorDTO.getYearOfBirth() != 0) {
            author = authorService.saveAuthor(new Author(
                    idService.incIdAuthor(),
                    authorDTO.getName(),
                    authorDTO.getSurname(),
                    authorDTO.getYearOfBirth(),
                    authorDTO.getCitizenship(),
                    authorDTO.getBiography(),
                    authorDTO.isStillAlive()));
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    new AuthorDTO().convertToAuthorDTO(author));
        }
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(authorDTO);
    }

    /**
     * This method delete all documents which contains incoming  name, surname and date
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAuthor(@RequestBody AuthorDTO authorDTO) {
        List<Author> authorList = authorService.deleteAuthor(new AuthorDTO().convertToAuthor(authorDTO));
        List<AuthorDTO> authorDTOList = new AuthorDTO().convertToAuthorDTOList(authorList);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(authorDTOList);
    }

    /**
     * This method return all documents which contains appropriate name or surname or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchAuthor(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "yearOfBirth", required = false) String yearOfBirth,
            @RequestParam(value = "citizenship", required = false) String citizenship,
            @RequestParam(value = "biography", required = false) String biography,
            @RequestParam(value = "stillAlive", required = false) String stillAlive) {
        if (yearOfBirth == null) {
            yearOfBirth = "0";
        }
        if (stillAlive != "true") {
            stillAlive = "false";
        }
        List<Author> authorList = authorService.findAuthor(new Author(
                0,
                name,
                surname,
                Integer.parseInt(yearOfBirth),
                citizenship,
                biography,
                stillAlive.contains("true")));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new AuthorDTO().convertToAuthorDTOList(authorList));
    }

    /**
     * Thise method updates appropriate entity in DB if find single entity by name, surname and yearOfBirth
     * else returns the list of entity
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new AuthorDTO().convertToAuthorDTOList(authorService.updateAuthor(
                        new AuthorDTO().convertToAuthor(authorDTO))));
    }
}
