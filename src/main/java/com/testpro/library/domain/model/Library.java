package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Library {

    private final int id;                   //ID
    private final String name;              //Наименование учреждения
    private final String address;           //Адрес учреждения
    private final int quantityWorker;       //количество работников

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
