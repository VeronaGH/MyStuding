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
    private final String[] nowBooks;        //Книги читает
    private final String[] earlieBooks;     //Ранее брал книги

    public Reeder(final int id, final String name, final String surname, final String address,
                  final State state, final String[] nowBooks, final String[] earlieBooks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.state = state;
        this.nowBooks = nowBooks;
        this.earlieBooks = earlieBooks;
    }

    public Reeder(final int id) {
        this.id = id;
        this.name = null;
        this.surname = null;
        this.address = null;
        this.state = null;
        this.nowBooks = null;
        this.earlieBooks = null;
    }

    public Reeder(final String name, final String surname) {
        this.id = 0;
        this.name = name;
        this.surname = surname;
        this.address = null;
        this.state = null;
        this.nowBooks = null;
        this.earlieBooks = null;
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

    public String[] getNowBooks() {
        return nowBooks;
    }

    public String[] getEarlieBooks() {
        return earlieBooks;
    }
}
