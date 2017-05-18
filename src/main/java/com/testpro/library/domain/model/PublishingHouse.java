package com.testpro.library.domain.model;

/**
 * Entity class for entity "PublishingHouse", immutable, has full constructor, has n't got overridden method toString();
 * Is necessary for storing a list of publishinghouse.
 */
public final class PublishingHouse {

    private final int id;
    private final String name;
    private final String address;
    private final String phone;
    private final String contact;

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
