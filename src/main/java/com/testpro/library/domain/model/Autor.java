package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Autor {

    private final int id;                       //ID
    private final String name;                  //Имя автора
    private final String surname;               //Фамилия автора
    private final int yearOfBirth;              //Год рождения
    private final String citizenship;           //Гражданство
    private final String biography;             //Краткая биография
    private final String[] bestSelers;          //Список бестселлеров
    private final int totalBooks;               //Общее количество написанных книжек
    private final boolean stillAlive;           //Статус - Все еще жив)

    public Autor(final int id, final String name, final String surname, final int yearOfBirth,
                 final String citizenship, final String biography, final String[] bestSelers,
                 final int totalBooks, final boolean stillAlive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.biography = biography;
        this.bestSelers = bestSelers;
        this.totalBooks = totalBooks;
        this.stillAlive = stillAlive;
    }

    public Autor(final int id) {
        this.id = id;
        this.name = null;
        this.surname = null;
        this.yearOfBirth = 0;
        this.citizenship = null;
        this.biography = null;
        this.bestSelers = null;
        this.totalBooks = 0;
        this.stillAlive = true;
    }

    public Autor(final String name, final String surname) {
        this.id = 0;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = 0;
        this.citizenship = null;
        this.biography = null;
        this.bestSelers = null;
        this.totalBooks = 0;
        this.stillAlive = true;
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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getBiography() {
        return biography;
    }

    public String[] getBestSelers() {
        return bestSelers;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public boolean isStillAlive() {
        return stillAlive;
    }
}
