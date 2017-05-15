package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Reeder {

    public enum State {Active, Blocked, Delited, Fined};

    private final int id;                   //ID
    private final String name;              //Имя читателя
    private final String surname;           //Фамилия читателя
    private final String address;           //Адрес читателя
    private final State state;              //Статус

    public Reeder(final int id, final String name, final String surname, final String address, final State state) {
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
