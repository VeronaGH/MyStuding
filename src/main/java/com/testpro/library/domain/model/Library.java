package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Library {

    private final int id;                   //ID
    private final String name;              //Наименование учреждения
    private final String address;           //Адрес учреждения
    private final int quantityWorker;       //количество работников
    private final int quantityBooks;        //Количество книг в библиотеке
    private final int quantityVisitors;     //Количество посетителей в месяц


    public Library(final int id, final String name, final String address,
                   final int quantityWorker, final int quantityBooks, final int quantityVisitors) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.quantityWorker = quantityWorker;
        this.quantityBooks = quantityBooks;
        this.quantityVisitors = quantityVisitors;
    }

    public Library(final int id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.quantityWorker = 0;
        this.quantityBooks = 0;
        this.quantityVisitors = 0;
    }

    public Library(final String name) {
        this.id = 0;
        this.name = name;
        this.address = null;
        this.quantityWorker = 0;
        this.quantityBooks = 0;
        this.quantityVisitors = 0;
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

    public int getQuantityBooks() {
        return quantityBooks;
    }

    public int getQuantityVisitors() {
        return quantityVisitors;
    }
}
