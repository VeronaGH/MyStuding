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
     * @param name String
     * @return List<Author>
     */
    List<Author> findAllByName(String name);

    /**
     * Find authors by surname
     *
     * @param surname String
     * @return List<Author>
     */
    List<Author> findAllBySurname(String surname);

    /**
     * Find authors by year of birth
     *
     * @param yearOfBirth int
     * @return List<Author>
     */
    List<Author> findAllByYearOfBirth(int yearOfBirth);

    /**
     * Find authors by citizenship
     *
     * @param citizenship String
     * @return List<Author>
     */
    List<Author> findAllByCitizenship(String citizenship);

    /**
     * Find author by name and surname
     *
     * @param name    String
     * @param surname String
     * @return List<Author>
     */
    List<Author> findAllByNameAndSurname(String name, String surname);

    /**
     * Find author by name, surname and year of birth
     *
     * @param name        String
     * @param surname     String
     * @param yearOfBirth int
     * @return Author
     */
    Author findOneByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);

    /**
     * Find author by name, surname and year of birth
     *
     * @param name        String
     * @param surname     String
     * @param yearOfBirth int
     * @return Author
     */
    List<Author> findAllByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);


    /**
     * Find author by name or surname
     *
     * @param name    String
     * @param surname String
     * @return List<Author>
     */
    List<Author> findAllByNameOrSurname(String name, String surname);

    /**
     * Find author by name or surname or year of birth
     *
     * @param name        String
     * @param surname     String
     * @param yearOfBirth int
     * @return List<Author>
     */
    List<Author> findAllByNameOrSurnameOrYearOfBirth(String name, String surname, int yearOfBirth);

    /**
     * Delete all authors by name, surname and yearOfBirth
     *
     * @param name        String
     * @param surname     String
     * @param yearOfBirth int
     * @return List<Author>
     */
    List<Author> deleteByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);
}
