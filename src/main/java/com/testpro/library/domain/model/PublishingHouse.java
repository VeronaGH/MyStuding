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

    public PublishingHouse(final int id, final String name, final String address, final String phone,
                           final String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
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

}
