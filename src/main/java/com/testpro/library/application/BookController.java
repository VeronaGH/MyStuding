package com.testpro.library.application;

import com.testpro.library.application.convertots.*;
import com.testpro.library.application.dto.*;
import com.testpro.library.domain.model.*;
import com.testpro.library.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for processing incoming json contains Book data
 */
@RestController
@RequestMapping(value = "/library/v1/books")
public class BookController {
    private final BookService bookService;
    private final BookConverter bookConverter;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final LibraryService libraryService;
    private final PublishingHouseService publishingHouseService;

    @Autowired
    public BookController(BookService bookService, BookConverter bookConverter, AuthorService authorService, GenreService genreService, LibraryService libraryService, PublishingHouseService publishingHouseService) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
        this.authorService = authorService;
        this.genreService = genreService;
        this.libraryService = libraryService;
        this.publishingHouseService = publishingHouseService;
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
     * This method delete all documents which contains incoming  library, name, author and year of publishing
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                bookConverter.convertToBookDTO(bookService.deleteBook(bookConverter.convertToBook(bookDTO))));
    }

    /**
     * This method return all documents which contains appropriate data or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchBook(
            @RequestParam(value = "library.Name", required = false) final String libraryName,
            @RequestParam(value = "library.Address", required = false) final String libraryAddress,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "author.Name", required = false) String  authorName,
            @RequestParam(value = "author.Surname", required = false) String authorSurname,
            @RequestParam(value = "author.YearOfBirth", required = false) String authorYearOfBirth,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "publishingHouse.Name", required = false) String publishingHouseName,
            @RequestParam(value = "publishingHouse.Address", required = false) String publishingHouseAddress,
            @RequestParam(value = "yearPublish", required = false) String yearPublish,
            @RequestParam(value = "bestSeller", required = false) String bestSeller,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "state", required = false) Book.State state) {

        int authorID = 0, libraryID = 0, genreID = 0, publishingHouseID = 0;

        if (yearPublish == null){
            yearPublish = "0";
        }
        if (bestSeller == null){
            bestSeller = "false";
        }
        if (authorYearOfBirth == null){
            authorYearOfBirth = "0";
        }

        List<Author> authors = authorService.findAuthor(new Author(
                0,
                authorName,
                authorSurname,
                Integer.valueOf(authorYearOfBirth),
                null,
                null,
                false));
        if (authors.size() == 1){
            authorID = authors.get(0).getId();
        }

        List<Library> libraries = libraryService.findLibrary(new Library(
                0,
                libraryName,
                libraryAddress,
                0));
        if(libraries.size() == 1){
            libraryID = libraries.get(0).getId();
        }

        Genre genres = genreService.findByName(new Genre(
                0,
                genre,
                null));
        if(genres != null){
            genreID = genres.getId();
        }

        List<PublishingHouse> publishingHouses = publishingHouseService.findPublishingHouse(new PublishingHouse(
                0,
                publishingHouseName,
                publishingHouseAddress,
                null,
                null));
        if(publishingHouses.size() == 1) {
            publishingHouseID = publishingHouses.get(0).getId();
        }

            List<Book> books = bookService.findBook(new Book(
                    0,
                    libraryID,
                    name,
                    authorID,
                    genreID,
                    publishingHouseID,
                    Integer.parseInt(yearPublish),
                    bestSeller.contains("true"),
                    description,
                    state));
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                    bookConverter.convertToBookDTOList(books));
    }

    /**
     * This method updates appropriate entity in DB if find single entity by library, name, author and year
     * of publishing, else returns the list of entity
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public  ResponseEntity updateBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                bookConverter.convertToBookDTOList(bookService.updateBook(bookConverter.convertToBook(bookDTO))));
    }
}
