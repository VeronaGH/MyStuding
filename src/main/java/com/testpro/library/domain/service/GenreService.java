package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Genre;
import com.testpro.library.domain.mongodb.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Genre DB
 */
@Component
public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Save method
     *
     * @param genre class
     * @return genre
     */
    public Genre storeGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * the delete method delete one entity, if found only one
     *
     * @param genre Genre
     * @return List<genre>
     */
    public List<Genre> deleteGenre(Genre genre) {
        List<Genre> genreList = genreRepository.findAllByName(genre.getName());
        if (genreList.size() == 1) {
            genreList = genreRepository.deleteAllByName(genre.getName());
        }
        return genreList;
    }

    /**
     * Find genre by name
     *
     * @param genre Genre
     * @return List<Genre>
     */
    public List<Genre> findByName(Genre genre) {
        return genreRepository.findAllByName(genre.getName());
    }

    /**
     * Return all genres from DB
     *
     * @return List<Genre>
     */
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public List<Genre> updateGenre(Genre genre) {
        List<Genre> genreList = genreRepository.findAllByName(genre.getName());
        if (genreList.size() == 1) {
            genreRepository.save(new Genre(
                    genreList.get(0).getId(),
                    genre.getName(),
                    genre.getDescription()));
            return genreRepository.findAllByName(genre.getName());
        }
        return genreRepository.findAll();
    }
}
