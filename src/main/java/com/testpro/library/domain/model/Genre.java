package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Genre {

    private final int id;                           //ID
    private final String name;                      //Жанр
    private final String description;               //Краткое описание

    public Genre(final int id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
