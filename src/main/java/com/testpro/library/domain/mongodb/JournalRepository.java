package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JournalRepository extends MongoRepository<Journal, String>{

    /**
     * Find Journal by it's Id
     * @param id int
     * @return Journal
     */
    Journal findOneById(int id);

    /**
     * Find Journal by it's LibraryId
     * @param libraryId int
     * @return Journal
     */
    List<Journal> findAllByLibraryId(int libraryId);

    /**
     * Find Journal by it's bookId
     * @param bookId int
     * @return Journal
     */
    List<Journal> findAllByBookId(int bookId);

    /**
     * Find Journal by it's readerId
     * @param readerId int
     * @return Journal
     */
    List<Journal> findAllByReaderId(int readerId);

    /**
     * Find Journal by amount of it's params
     * @param libraryId int
     * @param bookId int
     * @param readerId int
     * @return List<Journal>
     */
    List<Journal>findAllByLibraryIdAndBookIdAndReaderIdAndDayTaken(int libraryId, int bookId, int readerId, String DayTaken);

    /**
     * Delete Journal by it's Id
     * @param JournalId int
     * @return Journal
     */
    Journal deleteById(int JournalId);
}
