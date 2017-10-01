package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.BookDTO;
import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.service.AuthorService;
import com.testpro.library.domain.service.GenreService;
import com.testpro.library.domain.service.LibraryService;
import com.testpro.library.domain.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Book
 */
@Component
public class BookConverter {

    private final AuthorService authorService;
    private final GenreService genreService;
    private final LibraryService libraryService;
    private final PublishingHouseService publishingHouseService;

    @Autowired
    public BookConverter(AuthorService authorService, GenreService genreService, LibraryService libraryService, PublishingHouseService publishingHouseService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.libraryService = libraryService;
        this.publishingHouseService = publishingHouseService;
    }

    /**
     * Convert  BookDTO object to Book object
     *
     * @return Book
     */
    public Book convertToBook(BookDTO bookDTO) {
        return new Book(
                0,
                libraryService.returnLibraryId(new LibraryConverter().convertToLibrary(bookDTO.getLibraryDTO())),
                bookDTO.getName(),
                authorService.returnAuthorId(new AuthorConverter().convertToAuthor(bookDTO.getAuthorDTO())),
                genreService.returnGenreId(new GenreConverter().convertToGenre(bookDTO.getGenreDTO())),
                publishingHouseService.returnPublishingHouseId(new PublishingHouseConverter().convertToPublishHouse(bookDTO.getPublishingHouseDTO())),
                bookDTO.getYearPublish(),
                bookDTO.isBestSeller(),
                bookDTO.getDescription(),
                bookDTO.getState());
    }

    /**
     * Convert  Book object to BookDTO object
     *
     * @param book Book
     * @return BookDTO
     */
    public BookDTO convertToBookDTO(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(
                new LibraryConverter().convertToLibraryDTO(libraryService.findLibraryById(book.getLibraryId())),
                book.getName(),
                new AuthorConverter().convertToAuthorDTO(authorService.findAuthorByID(book.getAuthorId())),
                new GenreConverter().convertToGenreDTO(genreService.findGenreByID(book.getGenreId())),
                new PublishingHouseConverter().convertToPublishHouseDTO(publishingHouseService.findPublishingHouseById(book.getPublishingHouseId())),
                book.getYearPublish(),
                book.isBestSeller(),
                book.getDescription(),
                book.getState());
    }

    /**
     * Convert  List<Book> object to List<BookDTO> object
     *
     * @param bookList List<Book>
     * @return List<BookDTO>
     */
    public List<BookDTO> convertToBookDTOList(List<Book> bookList) {
        if (bookList == null) {
            return null;
        }
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for (Book book : bookList) {
            bookDTOList.add(convertToBookDTO(book));
        }
        return bookDTOList;
    }
}
