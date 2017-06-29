package com.testpro.library.domain.service;

import com.testpro.library.domain.model.IdKey;
import com.testpro.library.domain.mongodb.IdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This method is served for storing last 'id' of all schemas and providing it if necessary to save
 */
@Service
public class IdService {

    private final IdRepository idRepository;

    @Autowired
    public IdService(IdRepository idRepository) {
        this.idRepository = idRepository;
    }

    private void init() {
        if (idRepository.findById(1) == null) {
            idRepository.save(new IdKey(0, 0, 0, 0, 0, 0, 0));
        }
    }

    private IdKey getIdKey() {
        init();
        return idRepository.findById(1);
    }

    public int incIdAuthor() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                (idKey.getIdAuthor() + 1),
                idKey.getIdBook(),
                idKey.getIdGenre(),
                idKey.getIdJournal(),
                idKey.getIdLibrary(),
                idKey.getIdPublishingHouse(),
                idKey.getIdReader()));
        return (idKey.getIdAuthor() + 1);
    }

    public int incIdBook() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                (idKey.getIdBook() + 1),
                idKey.getIdGenre(),
                idKey.getIdJournal(),
                idKey.getIdLibrary(),
                idKey.getIdPublishingHouse(),
                idKey.getIdReader()));
        return (idKey.getIdBook() + 1);
    }

    public int incIdGenre() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                idKey.getIdBook(),
                (idKey.getIdGenre() + 1),
                idKey.getIdJournal(),
                idKey.getIdLibrary(),
                idKey.getIdPublishingHouse(),
                idKey.getIdReader()));
        return (idKey.getIdGenre() + 1);
    }

    public int incIdJournal() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                idKey.getIdBook(),
                idKey.getIdGenre(),
                (idKey.getIdJournal() + 1),
                idKey.getIdLibrary(),
                idKey.getIdPublishingHouse(),
                idKey.getIdReader()));
        return (idKey.getIdJournal() + 1);
    }

    public int incIdLibrary() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                idKey.getIdBook(),
                idKey.getIdGenre(),
                idKey.getIdJournal(),
                (idKey.getIdLibrary() + 1),
                idKey.getIdPublishingHouse(),
                idKey.getIdReader()));
        return (idKey.getIdLibrary() + 1);
    }

    public int incIdPublishingHouse() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                idKey.getIdBook(),
                idKey.getIdGenre(),
                idKey.getIdJournal(),
                idKey.getIdLibrary(),
                (idKey.getIdPublishingHouse() + 1),
                idKey.getIdReader()));
        return (idKey.getIdPublishingHouse() + 1);
    }

    public int incIdReader() {
        IdKey idKey = getIdKey();
        idRepository.save(new IdKey(
                idKey.getIdAuthor(),
                idKey.getIdBook(),
                idKey.getIdGenre(),
                idKey.getIdJournal(),
                idKey.getIdLibrary(),
                idKey.getIdPublishingHouse(),
                (idKey.getIdReader() + 1)));
        return (idKey.getIdReader() + 1);
    }
}