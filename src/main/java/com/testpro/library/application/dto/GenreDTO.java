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

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25, min = 3)
    private String name;

    @JsonProperty(value = "description")
    private String description;

    private GenreDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * This method convert GenreDTO to Genre
     *
     * @return Genre class
     */
    public Genre convertToGenre() {
        return new Genre(
                0,
                this.name,
                this.description);
    }

    /**
     * This method convert Genre to GenreDTO
     *
     * @param genre Genre
     * @return GenreDTO class
     */
    public GenreDTO convertToGenreDTO(Genre genre) {
        if (genre == null) {
            return null;
        }
        return new GenreDTO(
                genre.getName(),
                genre.getDescription());
    }

    /**
     * This method convert List<Genre> to List<GenreDTO>
     *
     * @param genreList List<Genre>
     * @return List<GenreDTO> class
     */
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
