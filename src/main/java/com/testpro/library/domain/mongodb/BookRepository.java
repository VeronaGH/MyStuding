package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of BookRepository
 */
public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Find book by library where stored
     * @param library int
     * @return List<Book>
     */
    List<Book> findAllByLibraryId(int library);

    /**
     * Find book by name
     * @param name String
     * @return List<Book>
     */
    List<Book> findAllByName(String name);

    /**
     * Find book by author
     * @param authorId int
     * @return List<Book>
     */
    List<Book> findAllByAuthorId(int authorId);

    /**
     * Find book by genre
     * @param genreId int
     * @return List<Book>
     */
    List<Book> findAllByGenreId(int genreId);

    /**
     * Find book by publish house
     * @param publishingHouseId class
     * @return List<Book>
     */
    List<Book> findAllByPublishingHouseId(int publishingHouseId);

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
    List<Book> findAllByState(Book.State state);


}
