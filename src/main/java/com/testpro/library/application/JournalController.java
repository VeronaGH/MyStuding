package com.testpro.library.application;

import com.testpro.library.application.convertots.JournalConverter;
import com.testpro.library.application.dto.JournalDTO;
import com.testpro.library.domain.model.*;
import com.testpro.library.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library/v1/journals")
public class JournalController {

    private final JournalService journalService;
    private final JournalConverter journalConverter;
    private final LibraryService libraryService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final AuthorService authorService;

    @Autowired
    public JournalController(JournalService journalService, JournalConverter journalConverter, LibraryService libraryService, BookService bookService, ReaderService readerService, AuthorService authorService) {
        this.journalService = journalService;
        this.journalConverter = journalConverter;
        this.libraryService = libraryService;
        this.bookService = bookService;
        this.readerService = readerService;
        this.authorService = authorService;
    }

    /**
     * Save method of controller, asses method 'POST'
     * save only in case library, book and reader has came.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeBook(@RequestBody final JournalDTO journalDTO) {
        if ((journalDTO.getLibraryDTO() != null) & (journalDTO.getBookDTO() != null) & (journalDTO.getReaderDTO() != null)) {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    journalConverter.convertToJournalDTO(journalService.storeJournal(journalConverter.convertToJournal(journalDTO))));
        } else
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(journalDTO);
    }

    /**
     * This method delete all documents which contains incoming  library, book and reader
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@RequestBody JournalDTO journalDTO){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                journalConverter.convertToJournalDTO(journalService.deleteJournal(journalConverter.convertToJournal(journalDTO))));
    }

    /**
     * This method return all documents which contains appropriate data or return all
     * documents, if parameters not defined.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchBook(
            @RequestParam(value = "library.Name", required = false) String libraryName,
            @RequestParam(value = "library.Address", required = false) String libraryAddress,
            @RequestParam(value = "book.Name", required = false) final String bookName,
            @RequestParam(value = "book.Author.Name", required = false) final String bookAuthorName,
            @RequestParam(value = "book.Author.Surname", required = false) final String bookAuthorSurname,
            @RequestParam(value = "book.Author.YearOfBirth", required = false) final String bookAuthorYearOfBirth,
            @RequestParam(value = "book.YearOfPublishing", required = false) String bookYearOfPublishing,
            @RequestParam(value = "dayTaken", required = false) String dayTaken,
            @RequestParam(value = "dayReturn", required = false) String  dayReturn,
            @RequestParam(value = "reader.Name", required = false) String readerName,
            @RequestParam(value = "reader.Surname", required = false) String readerSurname) {

        int libraryId = -1, authorId = -1, bookId = -1, readerId = -1;

        if (bookYearOfPublishing == null){
            bookYearOfPublishing = "0";
        }

        List<Library> libraries = libraryService.findLibrary(new Library(
                0,
                libraryName,
                libraryAddress,
                0));
        if(libraries.size() == 1){
            libraryId = libraries.get(0).getId();
        }

        List<Author> authors = authorService.findAuthor(new Author(
                0,
                bookAuthorName,
                bookAuthorSurname,
                Integer.parseInt(bookAuthorYearOfBirth),
                null,
                null,
                true));
        if (authors.size() == 1){
            authorId = authors.get(0).getId();
        }

        List<Book> books = bookService.findBook(new Book(
                0,
                libraryId,
                bookName,
                authorId,
                0,
                0,
                Integer.parseInt(bookYearOfPublishing),
                true,
                null,
                null));
        if(books != null){
            bookId = books.get(0).getId();
        }

        List<Reader> readers = readerService.findReader(new Reader(
                0,
                readerName,
                readerSurname,
                null,
                null));
        if(readers.size() == 1) {
            readerId = readers.get(0).getId();
        }

        List<Journal> journals = journalService.findJournal(new Journal(
                0,
                libraryId,
                bookId,
                dayTaken,
                dayReturn,
                readerId));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                journalConverter.convertToJournalDTOList(journals));
    }

    /**
     * This method updates appropriate entity in DB if find single entity by library, book and
     * reader, else returns the list of entity
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public  ResponseEntity updateBook(@RequestBody JournalDTO journalDTO){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                journalConverter.convertToJournalDTOList(journalService.updateJournal(journalConverter.convertToJournal(journalDTO))));
    }
}
