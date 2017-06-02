package com.testpro.library.domain.mongodb;

import com.testpro.library.domain.model.IdKey;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Pigas on 31.05.2017.
 */
public interface IdRepository extends MongoRepository<IdKey, String> {

    IdKey findById(int i);
}
