package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of AuthorRepository
 */
public interface AuthorRepository extends MongoRepository<Author, String>{
    List<Author> findAllByName(String name);
    List<Author> findAllBySurname(String surname);
    Author findByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);
    List<Author> findAllByCitizenship (String citizenship);
    List<Author> findAllByYearOfBirth (int yearOfBirth);
}