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
        isComingSoon
    }

    @Id
    private final int id;
    private final int libraryId;
    private final String name;
    private final int authorId;
    private final int genreId;
    private final int publishingHouseId;
    private final int yearPublish;
    private final boolean bestSeller;
    private final String description;
    private final State state;

    public Book(final int id, final int libraryId, final String name, final int authorId, final int genreId,
                final int publishingHouseId, final int yearPublish, final boolean bestSeller, final String description,
                final State state) {
        this.id = id;
        this.libraryId = libraryId;
        this.name = name;
        this.authorId = authorId;
        this.genreId = genreId;
        this.publishingHouseId = publishingHouseId;
        this.yearPublish = yearPublish;
        this.bestSeller = bestSeller;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public String getName() {
        return name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public int getPublishingHouseId() {
        return publishingHouseId;
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
