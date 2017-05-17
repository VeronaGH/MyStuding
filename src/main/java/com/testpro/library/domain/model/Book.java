package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Book {

    public enum State {inSight, isGiven, isSpoiled, isUnderRestoration, isCommingSoon}         //Перечисление состояний (в наличии, на руках, испорчена, реставрируется, скоро поступит в библиотеку)

    private final int id;                                                                       //ID
    private final Library lib;                                                                  //Находится в библиотеке
    private final String name;                                                                  //Название книги
    private final Author author;                                                                  //Автор книги
    private final Genre genre;                                                                  //Жанр
    private final String publishingHouse;                                                       //Издательство
    private final int yearPublish;                                                              //Год издания
    private final boolean bestSeler;                                                            //Является ли бестселлером
    private final String description;                                                           //Краткое описание
    private final State state;                                                                  //Текущее состояние

    public Book(final int id, final Library lib, final String name, final Author author, final Genre genre,
                final String publishingHouse, final int yearPublish, final boolean bestSeler, final String description,
                final State state) {
        this.id = id;
        this.lib = lib;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publishingHouse = publishingHouse;
        this.yearPublish = yearPublish;
        this.bestSeler = bestSeler;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public Library getLib() {return lib;}

    public String getName() {
        return name;
    }

    public Author getAutor() {return author;}

    public Genre getGenre() {return genre;}

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public boolean isBestSeler() {return bestSeler;}

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

}
