package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.IdKey;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Data asses interface for soring of last entity numbers at MongoDB
 */
public interface IdRepository extends MongoRepository<IdKey, String> {

    IdKey findById(int i);
}
