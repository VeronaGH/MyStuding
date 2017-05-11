package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Journal {

    private final int id;                   //ID
    private final String name;              //Название журналла
    private final String address;           //Адрес
    private final String phone;             //Контактный телефон
    private final String contact;           //Контактное лицо
    private final int circulation;          //Тираж
    private final String type;              //Вид издания (периодичность)

    public Journal(final int id, final String name, final String address, final String phone,
                           final String contact, final int circulation, final String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
        this.circulation = circulation;
        this.type = type;
    }

    public Journal(final int id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.phone = null;
        this.contact = null;
        this.circulation = 0;
        this.type = null;
    }

    public Journal(final String name) {
        this.id = 0;
        this.name = name;
        this.address = null;
        this.phone = null;
        this.contact = null;
        this.circulation = 0;
        this.type = null;
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

    public int getCirculation() {
        return circulation;
    }

    public String getType() {
        return type;
    }
}
