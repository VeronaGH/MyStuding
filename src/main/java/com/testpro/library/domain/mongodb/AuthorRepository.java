package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of AuthorRepository
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
    /**
     * Find authors by name
     *
     * @param name
     * @return List<Author>
     */
    List<Author> findAllByName(String name);

    /**
     * Find authors by surname
     *
     * @param surname
     * @return List<Author>
     */
    List<Author> findAllBySurname(String surname);

    /**
     * Find author by name, surname and year of birth
     *
     * @param name
     * @param surname
     * @param yearOfBirth
     * @return Author
     */
    Author findByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);

    /**
     * Find authors by citizenship
     *
     * @param citizenship
     * @return List<Author>
     */
    List<Author> findAllByCitizenship(String citizenship);

    /**
     * Find authors by year of birth
     *
     * @param yearOfBirth
     * @return List<Author>
     */
    List<Author> findAllByYearOfBirth(int yearOfBirth);
}
