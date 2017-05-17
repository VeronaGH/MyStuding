package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Pigas on 16.05.2017.
 */
public interface AuthorRepository extends MongoRepository<Author, String>{
    List<Author> findAllByName(String name);
    List<Author> findAllBySurname(String surname);
    Author findByNameAndSurnameAndYearOfBirth(String name, String surname, int yearOfBirth);
    List<Author> findAllByCitizenship (String citizenship);
    List<Author> findAllByYearOfBirth (int yearOfBirth);
}
