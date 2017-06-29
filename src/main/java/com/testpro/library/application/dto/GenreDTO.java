package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Genre;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object class for parsing incoming data for GenreController
 */
public class GenreDTO implements Serializable {

    @JsonProperty
    @NotBlank
    @Size (max=25)
    private String name;

    @JsonProperty
    private String description;

    private GenreDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre convertToGenre(GenreDTO genreDTO) {
        return new Genre(
                0,
                genreDTO.getName(),
                genreDTO.getDescription());
    }

    public GenreDTO convertToGenreDTO(Genre genre) {
        return new GenreDTO(
                genre.getName(),
                genre.getDescription());
    }

    public List<GenreDTO> convertToGenreDTOList(List<Genre> genreList) {
        List<GenreDTO> genreDTOList = new ArrayList<GenreDTO>();
        for (Genre genre : genreList) {
            genreDTOList.add(convertToGenreDTO(genre));
        }
        return genreDTOList;
    }

    public GenreDTO() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
