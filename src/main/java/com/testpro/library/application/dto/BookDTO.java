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
public class BookDTO implements Serializable {

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
     * @return Book
     */
    public Book convertToBook() {

        return new Book(
                0,
                this.lib,
                this.name,
                this.author,
                this.genre,
                this.publishingHouse,
                this.yearPublish,
                this.bestSeller,
                this.description,
                this.state);
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
