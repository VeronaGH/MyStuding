package com.testpro.library.domain.model;

import org.springframework.data.annotation.Id;

/**
 * Entity class for entity "Book", immutable, has full constructor, has n't got overridden method toString();
 */
public final class Book {

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
        isCommingSoon
    }

    @Id
    private final int id;
    private final Library lib;
    private final String name;
    private final Author author;
    private final Genre genre;
    private final String publishingHouse;
    private final int yearPublish;
    private final boolean bestSeller;
    private final String description;
    private final State state;

    public Book(final int id, final Library lib, final String name, final Author author, final Genre genre,
                final String publishingHouse, final int yearPublish, final boolean bestSeller, final String description,
                final State state) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public Library getLib() {
        return lib;
    }

    public String getName() {
        return name;
    }

    public Author getAutor() {
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

    public State getState() {
        return state;
    }

}
