package com.testpro.library.domain.model;

import org.springframework.data.annotation.Id;

/**
 * Entity class for entity "Library", immutable, has full constructor, has n't got overridden method toString();
 * Is necessary for storing a list of libraries.
 */
public final class Library {

    @Id
    private final int id;
    private final String name;
    private final String address;
    private final int quantityWorkers;

    public Library(final int id, final String name, final String address, final int quantityWorkers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.quantityWorkers = quantityWorkers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getQuantityWorkers() {
        return quantityWorkers;
    }

}
