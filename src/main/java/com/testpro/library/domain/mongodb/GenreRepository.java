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
     * @param name String
     * @return List<Genre>
     */
    List<Genre> findAllByName(String name);

    /**
     * Delete Genre by it's name
     * @param name String
     * @return List<Genre>
     */
    List<Genre> deleteAllByName(String name);
}
