package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of GenreRepository
 */
public interface GenreRepository extends MongoRepository<Genre, String> {

    /**
     * Find genre by it's name
     *
     * @param name String
     * @return Genre
     */
    Genre findOneByName(String name);

    /**
     * Delete Genre by it's name
     *
     * @param name String
     * @return Genre
     */
    List<Genre> deleteGenreByName(String name);

    /**
     * Find entity by ID
     *
     * @param id int
     * @return Genre
     */
    Genre findOneById(int id);
}
