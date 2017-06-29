package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.model.Genre;
import com.testpro.library.domain.model.Library;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object class for parsing incoming data for BookController
 */
public class BookDTO implements Serializable{

    private BookDTO(Library lib, String name, Author author, Genre genre, String publishingHouse, int yearPublish, boolean bestSeller, String description, Book.State state) {
        this.lib = lib;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publishingHouse = publishingHouse;
        this.yearPublish = yearPublish;
        this.bestSeller = bestSeller;
        this.description = description;
        this.state = state;
    }

    public BookDTO() {
    }

    /**
     * Convert  BookDTO object to Book object
     *
     * @param bookDTO BookDTO
     * @return Book
     */
    public Book convertToBook(BookDTO bookDTO) {

        return new Book(
                0,
                bookDTO.getLib(),
                bookDTO.getName(),
                bookDTO.getAuthor(),
                bookDTO.getGenre(),
                bookDTO.getPublishingHouse(),
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
        return new BookDTO(
                book.getLib(),
                book.getName(),
                book.getAutor(),
                book.getGenre(),
                book.getPublishingHouse(),
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
    public List<BookDTO> convertToBookList(List<Book> bookList) {
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for (Book book : bookList) {
            bookDTOList.add(convertToBookDTO(book));
        }
        return bookDTOList;
    }

    public enum State {
        /**
         * Stored at the library
         */
        inSight,

        /**
         * Reader has taken this book
         */
        isGiven,

        /**
         * Tre book is spoiled and is waiting for reparation
         */
        isSpoiled,

        /**
         * The book is under reparation
         */
        isUnderRestoration,

        /**
         * The book is coming soon to the library
         */
        isCommingSoon
    }

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private Library lib;

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private String name;

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private Author author;

    @JsonProperty
    private Genre genre;

    @JsonProperty
    private String publishingHouse;

    @JsonProperty
    private int yearPublish;

    @JsonProperty
    private boolean bestSeller;

    @JsonProperty
    private String description;

    @JsonProperty
    private Book.State state;

    public Library getLib() {
        return lib;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public String getDescription() {
        return description;
    }

    public Book.State getState() {
        return state;
    }
}
