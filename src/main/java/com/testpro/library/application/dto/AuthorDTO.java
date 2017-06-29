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

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private String name;

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private String surname;

    @JsonProperty
    private int yearOfBirth;

    @JsonProperty
    private String citizenship;

    @JsonProperty
    private String biography;

    @JsonProperty
    private boolean stillAlive;

    public AuthorDTO(){
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
     * @param authorDTO AuthorDTO
     * @return Author
     */
    public Author convertToAuthor(AuthorDTO authorDTO) {
        return new Author(
                0,
                authorDTO.getName(),
                authorDTO.getSurname(),
                authorDTO.getYearOfBirth(),
                authorDTO.getCitizenship(),
                authorDTO.getBiography(),
                authorDTO.isStillAlive());
    }

    /**
     * Convert  List<Author> object to List<AuthorDTO> object
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
