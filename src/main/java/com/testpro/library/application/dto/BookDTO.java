package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Book;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * Data transfer object class for parsing incoming data for BookController
 */
public class BookDTO implements Serializable {

    public BookDTO(LibraryDTO libraryDTO, String name, AuthorDTO authorDTO, GenreDTO genreDTO, PublishingHouseDTO publishingHouseDTO, int yearPublish, boolean bestSeller, String description, Book.State state) {
        this.libraryDTO = libraryDTO;
        this.name = name;
        this.authorDTO = authorDTO;
        this.genreDTO = genreDTO;
        this.publishingHouseDTO = publishingHouseDTO;
        this.yearPublish = yearPublish;
        this.bestSeller = bestSeller;
        this.description = description;
        this.state = state;
    }

    public BookDTO() {
    }

    @JsonProperty(value = "library")
    @NotBlank
    @Size(max = 25)
    private LibraryDTO libraryDTO;

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25)
    private String name;

    @JsonProperty(value = "author")
    @NotBlank
    @Size(max = 25)
    private AuthorDTO authorDTO;

    @JsonProperty(value = "genre")
    private GenreDTO genreDTO;

    @JsonProperty(value = "publishingHouse")
    private PublishingHouseDTO publishingHouseDTO;

    @JsonProperty(value = "yearPublish")
    private int yearPublish;

    @JsonProperty(value = "bestSeller")
    private boolean bestSeller;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "state")
    private Book.State state;

    public LibraryDTO getLibraryDTO() {
        return libraryDTO;
    }

    public String getName() {
        return name;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public GenreDTO getGenreDTO() {
        return genreDTO;
    }

    public PublishingHouseDTO getPublishingHouseDTO() {
        return publishingHouseDTO;
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
