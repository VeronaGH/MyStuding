package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Book {

    public enum State {inSight, isGiven, isSpoiled, isUnderRestoration, isCommingSoon}         //Перечисление состояний (в наличии, на руках, испорчена, реставрируется, скоро поступит в библиотеку)

    private final int id;                                                                       //ID
    private final String name;                                                                  //Название книги
    private final String autor;                                                                 //Автор книги
    private final String genre;                                                                 //Жанр
    private final String publishingHouse;                                                       //Издательство
    private final int yearPublish;                                                              //Год издания
    private final String[] description;                                                         //Краткое описание
    private final State state;                                                                  //Текущее состояние
    private final String[] prevOwners;                                                          //Предыдущие читатели

    public Book(final int id, final String name, final String autor, final String genre, final String publishingHouse,
                final int yearPublish, final String[] description, final State state, final String[] prevOwners) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.genre = genre;
        this.publishingHouse = publishingHouse;
        this.yearPublish = yearPublish;
        this.description = description;
        this.state = state;
        this.prevOwners = prevOwners;
    }

    public Book(final int id) {
        this.id = id;
        this.name = null;
        this.autor = null;
        this.genre = null;
        this.publishingHouse = null;
        this.yearPublish = 0;
        this.description = null;
        this.state = null;
        this.prevOwners = null;
    }

    public Book(final String name, final String autor) {
        this.id = 0;
        this.name = name;
        this.autor = autor;
        this.genre = null;
        this.publishingHouse = null;
        this.yearPublish = 0;
        this.description = null;
        this.state = null;
        this.prevOwners = null;
    }

    public Book(final State state) {
        this.id = 0;
        this.name = null;
        this.autor = null;
        this.genre = null;
        this.publishingHouse = null;
        this.yearPublish = 0;
        this.description = null;
        this.state = state;
        this.prevOwners = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public String[] getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

    public String[] getPrevOwners() {
        return prevOwners;
    }
}
