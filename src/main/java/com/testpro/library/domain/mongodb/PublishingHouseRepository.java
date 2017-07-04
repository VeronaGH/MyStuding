package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.PublishingHouse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface containing declarations of asses methods to db of PublishingHouseRepository
 */
public interface PublishingHouseRepository extends MongoRepository<PublishingHouse, String> {

    /**
     * Find all by name
     *
     * @param name String
     * @return List<PublishingHouse>
     */
    List<PublishingHouse> findAllByName(String name);

    /**
     * Find all by address
     *
     * @param address String
     * @return List<PublishingHouse>
     */
    List<PublishingHouse> findAllByAddress(String address);

    /**
     * Find entity by name and address
     *
     * @param name, address String
     * @return List<PublishingHouse>
     */
    PublishingHouse findByNameAndAddress(String name, String address);

    /**
     * Find all by name or address
     *
     * @param name, address String
     * @return List<PublishingHouse>
     */
    List<PublishingHouse> findAllByNameOrAddress(String name, String address);

    /**
     * Delete by name or address
     *
     * @param name, address String
     * @return List<PublishingHouse>
     */
    List<PublishingHouse> deleteByNameAndAddress(String name, String address);

    /**
     * Find entity by it's ID
     *
     * @param id int
     * @return PublishingHouse
     */
    PublishingHouse findOneById(int id);

}
