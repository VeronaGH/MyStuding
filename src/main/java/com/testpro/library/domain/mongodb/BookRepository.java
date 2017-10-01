package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of BookRepository
 */
public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Find book by library where stored
     *
     * @param library int
     * @return List<Book>
     */
    List<Book> findAllByLibraryId(int library);

    /**
     * Find book by name
     *
     * @param name String
     * @return List<Book>
     */
    List<Book> findAllByName(String name);

    /**
     * Find book by author
     *
     * @param authorId int
     * @return List<Book>
     */
    List<Book> findAllByAuthorId(int authorId);

    /**
     * Find book by sufficient params (4)
     * @param libraryId int
     * @param name String
     * @param AuthorId int
     * @param yearOfPublishing int
     * @return List<Book>
     */
    List<Book> findAllByLibraryIdAndNameAndAuthorIdAndYearPublish(int libraryId, String name, int AuthorId, int yearOfPublishing);

    /**
     * Delete book by sufficient params (4)
     * @param libraryId int
     * @param name String
     * @param AuthorId int
     * @param yearOfPublishing int
     * @return List<Book>
     */
    List<Book> deleteAllByLibraryIdAndNameAndAuthorIdAndYearPublish(int libraryId, String name, int AuthorId, int yearOfPublishing);

    /**
     * Find one book by sufficient params (4)
     * @param libraryId int
     * @param name String
     * @param AuthorId int
     * @param yearOfPublishing int
     * @return List<Book>
     */
    Book findOneByLibraryIdAndNameAndAuthorIdAndYearPublish(int libraryId, String name, int AuthorId, int yearOfPublishing);

    /**
     * Find one book by sufficient params (3)
     * @param name String
     * @param AuthorId int
     * @param yearOfPublishing int
     * @return List<Book>
     */
    List<Book> findAllByNameAndAuthorIdAndYearPublish(String name, int AuthorId, int yearOfPublishing);

    /**
     * Find book in DB by it's ID
     * @param id int
     * @return Book
     */
    Book findById(int id);
}
