package com.testpro.library.domain.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Entity class for entity "Author", immutable, has full constructor, overridden method toString();
 */
public final class Author implements Serializable {

    @Id
    private final int id;
    private final String name;
    private final String surname;
    private final int yearOfBirth;
    private final String citizenship;
    private final String biography;
    private final boolean stillAlive;

    public Author(final int id, final String name, final String surname, final int yearOfBirth,
                  final String citizenship, final String biography, final boolean stillAlive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.biography = biography;
        this.stillAlive = stillAlive;
    }

    @Override
    public String toString() {
        return "id : " + id + ",    name : " + name + ",    surname : " + surname
                + ",    yearOfBirth : " + yearOfBirth + ",    citizenship : " + citizenship
                + ",    biography : " + biography + ",    stillAlive : " + stillAlive;
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
