package com.testpro.library.domain.model;

/**
 * Entity class for entity "Jornal", immutable, has full constructor, has n't got overridden method toString();
 * Is necessary for storing of a book using history.
 */
public final class Journal {

    /**
     * enum determining the state of a book
     */
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
        isCommingSoon};

    private final long id;
    private final Library forLib;
    private final Book book;
    private final String dayTaken;
    private final String dayReturn;
    private final Reader reader;
    private final State state;

    public Journal(final long id, final Library forLib, final Book book, final String dayTaken,
                   final String dayReturn, final Reader reader, final State state) {
        this.id = id;
        this.forLib = forLib;
        this.book = book;
        this.dayTaken = dayTaken;
        this.dayReturn = dayReturn;
        this.reader = reader;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public Library getForLib() {
        return forLib;
    }

    public Book getBook() {
        return book;
    }

    public String getDayTaken() {
        return dayTaken;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public Reader getReader() {
        return reader;
    }

    public State getState() {
        return state;
    }
}
