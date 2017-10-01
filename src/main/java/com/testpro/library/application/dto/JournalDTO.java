package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for JournalController
 */
public class JournalDTO implements Serializable {

    public JournalDTO(LibraryDTO libraryDTO, BookDTO bookDTO, String dayTaken, String dayReturn, ReaderDTO readerDTO) {
        this.libraryDTO = libraryDTO;
        this.bookDTO = bookDTO;
        this.dayTaken = dayTaken;
        this.dayReturn = dayReturn;
        this.readerDTO = readerDTO;
    }

    public JournalDTO() {
    }

    @JsonProperty(value = "library")
    @NotBlank
    private LibraryDTO libraryDTO;

    @JsonProperty(value = "book")
    @NotBlank
    private BookDTO bookDTO;

    @JsonProperty(value = "dayTaken")
    @NotBlank
    @Size(min = 10, max = 10)
    private String dayTaken;

    @JsonProperty(value = "dayReturn")
    @Size(min = 10, max = 10)
    private String dayReturn;

    @JsonProperty(value = "reader")
    @NotBlank
    private ReaderDTO readerDTO;

    public LibraryDTO getLibraryDTO() {
        return libraryDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public String getDayTaken() {
        return dayTaken;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public ReaderDTO getReaderDTO() {
        return readerDTO;
    }
}
