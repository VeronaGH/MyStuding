package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for AuthorController
 */
public class AuthorDTO implements Serializable {

    public AuthorDTO(String name, String surname, int yearOfBirth, String citizenship, String biography, boolean stillAlive) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.biography = biography;
        this.stillAlive = stillAlive;
    }

    public AuthorDTO() {
    }

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25, min = 2)
    private String name;

    @JsonProperty(value = "surname")
    @NotBlank
    @Size(max = 25)
    private String surname;

    @JsonProperty(value = "yearOfBirth")
    @NotBlank
    private int yearOfBirth;

    @JsonProperty(value = "citizenship")
    private String citizenship;

    @JsonProperty(value = "biography")
    private String biography;

    @JsonProperty(value = "stillAlive")
    private boolean stillAlive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
