package com.testpro.library.domain.model;

/**
 * Entity class for entity "Library", immutable, has full constructor, has n't got overridden method toString();
 * Is necessary for storing a list of libraries.
 */
public final class Library {

    private final int id;
    private final String name;
    private final String address;
    private final int quantityWorker;

    public Library(final int id, final String name, final String address, final int quantityWorker) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.quantityWorker = quantityWorker;
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

    public int getQuantityWorker() {
        return quantityWorker;
    }

}
