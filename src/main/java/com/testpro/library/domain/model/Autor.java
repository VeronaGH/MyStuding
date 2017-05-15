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
    private final boolean stillAlive;           //Статус - Все еще жив)

    public Autor(final int id, final String name, final String surname, final int yearOfBirth,
                 final String citizenship, final String biography, final boolean stillAlive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.biography = biography;
        this.stillAlive = stillAlive;
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

    public boolean isStillAlive() {
        return stillAlive;
    }
}
