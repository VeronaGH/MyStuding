package com.testpro.library.domain.model;

import org.springframework.data.annotation.Id;

/**
 * Entity class for entity "Genre", immutable, has full constructor, has n't got overridden method toString();
 */
public final class Genre {

    @Id
    private final int id;
    private final String name;
    private final String description;

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