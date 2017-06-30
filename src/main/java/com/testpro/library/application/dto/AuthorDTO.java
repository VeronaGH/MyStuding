package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Author;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object class for parsing incoming data for AuthorController
 */
public class AuthorDTO implements Serializable {

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

    public AuthorDTO() {
    }

    private AuthorDTO(String name, String surname, int yearOfBirth, String citizenship, String biography, boolean stillAlive) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.citizenship = citizenship;
        this.biography = biography;
        this.stillAlive = stillAlive;
    }

    /**
     * Convert  Author object to AuthorDTO object
     *
     * @param author Author
     * @return AuthorDTO
     */
    public AuthorDTO convertToAuthorDTO(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDTO(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth(),
                author.getCitizenship(),
                author.getBiography(),
                author.isStillAlive());
    }

    /**
     * Convert  AuthorDTO object to Author object
     *
     * @return Author
     */
    public Author convertToAuthor() {
        return new Author(
                0,
                this.name,
                this.surname,
                this.yearOfBirth,
                this.citizenship,
                this.biography,
                this.stillAlive);
    }

    /**
     * Convert  List<Author> object to List<AuthorDTO> object
     *
     * @param authorList List<Author>
     * @return List<AuthorDTO>
     */
    public List<AuthorDTO> convertToAuthorDTOList(List<Author> authorList) {
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();
        for (Author author : authorList) {
            authorDTOList.add(convertToAuthorDTO(author));
        }
        return authorDTOList;
    }

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
