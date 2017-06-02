package com.testpro.library.domain.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Pigas on 31.05.2017.
 */
public class IdKey {

    @Id
    private final int id;
    private final int idAuthor;
    private final int idBook;
    private final int idGenre;
    private final int idJournal;
    private final int idLibrary;
    private final int idPublishingHouse;
    private final int idReader;

    public IdKey(int idAuthor, int idBook, int idGenre, int idJournal, int idLibrary, int idPublishingHouse, int idReader) {
        this.id = 1;
        this.idAuthor = idAuthor;
        this.idBook = idBook;
        this.idGenre = idGenre;
        this.idJournal = idJournal;
        this.idLibrary = idLibrary;
        this.idPublishingHouse = idPublishingHouse;
        this.idReader = idReader;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public int getIdJournal() {
        return idJournal;
    }

    public int getIdLibrary() {
        return idLibrary;
    }

    public int getIdPublishingHouse() {
        return idPublishingHouse;
    }

    public int getIdReader() {
        return idReader;
    }
}
