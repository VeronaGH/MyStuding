package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class PublishingHouse {

    private final int id;                   //ID
    private final String name;              //Название издательства
    private final String address;           //Адрес
    private final String phone;             //Контактный телефон
    private final String contact;           //Контактное лицо
    private final int quantityBook;         //Количество выпущенных книг

    public PublishingHouse(final int id, final String name, final String address, final String phone,
                           final String contact, final int quantityBook) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
        this.quantityBook = quantityBook;
    }

    public PublishingHouse(final int id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.phone = null;
        this.contact = null;
        this.quantityBook = 0;
    }

    public PublishingHouse(final String name) {
        this.id = 0;
        this.name = name;
        this.address = null;
        this.phone = null;
        this.contact = null;
        this.quantityBook = 0;
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

    public String getPhone() {
        return phone;
    }

    public String getContact() {
        return contact;
    }

    public int getQuantityBook() {
        return quantityBook;
    }
}
