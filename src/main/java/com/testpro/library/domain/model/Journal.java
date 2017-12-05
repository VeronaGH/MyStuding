package com.testpro.library.domain.model;

import org.springframework.stereotype.Component;

/**
 * Entity class for entity "Journal", immutable, has full constructor, has n't got overridden method toString();
 * Is necessary for storing of a book using history.
 */
public final class Journal {

    private final int id;
    private final int libraryId;
    private final int bookId;
    private final String dayTaken;
    private final String dayReturn;
    private final int readerId;

    public Journal(int id, int libraryID, int bookId, String dayTaken, String dayReturn, int readerID) {
        this.id = id;
        this.libraryId = libraryID;
        this.bookId = bookId;
        this.dayTaken = dayTaken;
        this.dayReturn = dayReturn;
        this.readerId = readerID;
    }

    public int getId() {
        return id;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getDayTaken() {
        return dayTaken;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public int getReaderId() {
        return readerId;
    }
}
