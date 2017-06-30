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
        Genre savingGenre = genreRepository.findOneByName(genre.getName());
        if (savingGenre == null) {
            return genreRepository.save(genre);
        }
        return null;
    }

    /**
     * the delete method delete one entity, if found only one
     *
     * @param genre Genre
     * @return List<genre>
     */
    public Genre deleteGenre(Genre genre) {
        Genre deletingGenre = genreRepository.findOneByName(genre.getName());
        if (deletingGenre != null) {
            return genreRepository.deleteGenreByName(genre.getName()).get(0);
        }
        return null;
    }

    /**
     * Find genre by name
     *
     * @param genre Genre
     * @return List<Genre>
     */
    public Genre findByName(Genre genre) {
        return genreRepository.findOneByName(genre.getName());
    }

    /**
     * Return all genres from DB
     *
     * @return List<Genre>
     */
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    /**
     * Update genre from DB if could found, else return null
     *
     * @param genre Genre
     * @return Genre
     */
    public Genre updateGenre(Genre genre) {
        Genre updatingGenre = genreRepository.findOneByName(genre.getName());
        if (updatingGenre != null) {
            genreRepository.save(new Genre(
                    updatingGenre.getId(),
                    genre.getName(),
                    genre.getDescription()));
            return genreRepository.findOneByName(genre.getName());
        }
        return null;
    }
}
