package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.GenreDTO;
import com.testpro.library.domain.model.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Genre
 */
@Component
public class GenreConverter {

    /**
     * This method convert GenreDTO to Genre
     *
     * @return Genre class
     */
    public Genre convertToGenre(GenreDTO genreDTO) {
        return new Genre(
                0,
                genreDTO.getName(),
                genreDTO.getDescription());
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


}
