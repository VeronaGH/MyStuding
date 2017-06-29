package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.model.Genre;
import com.testpro.library.domain.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of BookRepository
 */
public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Find book by library where stored
     * @param lib Library
     * @return List<Book>
     */
    List<Book> findAllByLib(Library lib);

    /**
     * Find book by name
     * @param name String
     * @return List<Book>
     */
    List<Book> findAllByName(String name);

    /**
     * Find book by author
     * @param author Author
     * @return List<Book>
     */
    List<Book> findAllByAuthor(Author author);

    /**
     * Find book by genre
     * @param genre Genre
     * @return List<Book>
     */
    List<Book> findAllByGenre(Genre genre);

    /**
     * Find book by publish house
     * @param publishingHouse String
     * @return List<Book>
     */
    List<Book> findAllByPublishingHouse(String publishingHouse);

    /**
     * Find book by year when it was published
     * @param yearPublish int
     * @return List<Book>
     */
    List<Book> findAllByYearPublish(int yearPublish);

    /**
     * Find books bestsellers
     * @param bestSeller Boolean
     * @return List<Book>
     */
    List<Book> findAllByBestSeller(Boolean bestSeller);

    /**
     * Find books by state
     * @param state String
     * @return List<Book>
     */
    List<Book> findAllByState(String state);


}
