package com.testpro.library.domain.model;

/**
 * Entity class for entity "Reader", immutable, has full constructor, has n't got overridden method toString();
 */
public final class Reader {

    /**
     * enum state of readers
     */
    public enum State {
        /**
         * Everything is normal and reader could take books from the library
         */
        Active,
        /**
         * Something is wrong and reader couldn't take any books from library
         */
        Blocked,
        /**
         * The reader signature is marked as archived
         */
        Deleted,
        /**
         * The reader is fined and blocked
         */
        Fined
    }

    private final int id;
    private final String name;
    private final String surname;
    private final String address;
    private final State state;

    public Reader(final int id, final String name, final String surname, final String address, final State state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public State getState() {
        return state;
    }

}
