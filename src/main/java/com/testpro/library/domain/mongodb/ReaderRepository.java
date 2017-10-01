package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of ReaderRepository
 */
public interface ReaderRepository extends MongoRepository<Reader, String> {

    /**
     * find Reader by it's name
     *
     * @param name String
     * @return List<Reader>
     */
    List<Reader> findAllByName(String name);

    /**
     * find Reader by it's surname
     *
     * @param surname String
     * @return List<Reader>
     */
    List<Reader> findAllBySurname(String surname);

    /**
     * find Reader by it's address
     *
     * @param address String
     * @return List<Reader>
     */
    List<Reader> findAllByAddress(String address);

    /**
     * find Reader by it's state
     *
     * @param state String
     * @return List<Reader>
     */
    List<Reader> findAllByState(Reader.State state);

    /**
     * find first (and single) Reader by it's name and surname
     *
     * @param name    String
     * @param surname String
     * @return List<Reader>
     */
    Reader findFirstByNameAndSurname(String name, String surname);

    /**
     * find all Readers by their's name and surname
     *
     * @param name    String
     * @param surname String
     * @return List<Reader>
     */
    List<Reader> findAllByNameAndSurname(String name, String surname);

    /**
     * find all Readers by their's name or surname
     *
     * @param name    String
     * @param surname String
     * @return List<Reader>
     */
    List<Reader> findAllByNameOrSurname(String name, String surname);

    /**
     * delete all (but their is only one such reader) Readers by their's name or surname
     *
     * @param name    String
     * @param surname String
     * @return List<Reader>
     */
    List<Reader> deleteReaderByNameAndSurname(String name, String surname);

    /**
     * find one Readers by their's name or surname
     *
     * @param name String
     * @param surname String
     * @return Reader
     */
    Reader findOneByNameAndSurname(String name, String surname);

    /**
     * find one Readers by ID
     *
     * @param readerId int
     * @return Reader
     */
    Reader findOneById(int readerId);
}
