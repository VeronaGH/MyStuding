package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of LibraryRepository
 */
public interface LibraryRepository extends MongoRepository<Library, String> {

    /**
     * Find library by name
     *
     * @param name
     * @return List<Library>
     */
    List<Library> findAllByName(String name);

    /**
     * Find library by address
     *
     * @param address
     * @return List<Library>
     */
    List<Library> findAllByAddress(String address);

    /**
     * Delete all documents by name of library and address
     *
     * @param name
     * @param Address
     * @return List<Library>
     */
    List<Library> deleteByNameAndAddress(String name, String Address);

    /**
     * Find all Libraries by their name and address
     *
     * @param name
     * @param address
     * @return List<Library>
     */
    List<Library> findAllByNameOrAddress(String name, String address);
}
