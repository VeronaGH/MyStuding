package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Library;
import com.testpro.library.domain.mongodb.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pigas on 31.05.2017.
 */
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public List<Library> deleteLibrary(Library library) {
        return libraryRepository.deleteAllByNameAndAddress(library.getName(), library.getAddress());
    }

    public List<Library> reedLibrary() {
        return libraryRepository.findAll();
    }

    public List<Library> findLibraryByNameOrAdress(Library library) {
        return libraryRepository.findAllByNameOrAddress(library.getName(), library.getAddress());
    }

    public List<Library> updateLibrary(Library library) {
        List<Library> updatingLibrary;
        updatingLibrary = libraryRepository.findAllByName(library.getName());
        if (updatingLibrary.size() == 1) {
            libraryRepository.save(new Library(
                    updatingLibrary.get(0).getId(),
                    library.getName(),
                    library.getAddress(),
                    library.getQuantityWorkers()));
        }
        return updatingLibrary;
    }
}
