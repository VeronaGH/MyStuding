package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Library;
import com.testpro.library.domain.mongodb.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Library DB
 */
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    /**
     * Save method
     *
     * @param library class
     * @return library
     */
    public Library saveLibrary(Library library) {
        if (libraryRepository.findAllByNameAndAddress(library.getName(), library.getAddress()).isEmpty()) {
            return libraryRepository.save(library);
        }
        return null;
    }

    /**
     * Delete method
     *
     * @param library class
     * @return List<Library>
     */
    public Library deleteLibrary(Library library) {
        List<Library> deleteLibrary = libraryRepository.deleteByNameAndAddress(library.getName(), library.getAddress());
        if(!deleteLibrary.isEmpty()) {
            return deleteLibrary.get(0);
        }
        return null;
    }

    /**
     * Find all entity
     *
     * @return List<Library>
     */
    public List<Library> readLibrary() {
        return libraryRepository.findAll();
    }

    /**
     * Find entity by its name or address
     *
     * @param library class
     * @return List<Library>
     */
    public List<Library> findLibraryByNameOrAdress(Library library) {
        return libraryRepository.findAllByNameOrAddress(library.getName(), library.getAddress());
    }

    /**
     * Find libraries by theirs name, if found only one - refresh entity at the DB, in other case - return all entity
     * witch has found
     *
     * @param library class
     * @return List<Library>
     */
    public List<Library> updateLibrary(Library library) {
        List<Library> updatingLibrary;
        updatingLibrary = libraryRepository.findAllByName(library.getName());
        if (updatingLibrary.size() == 1) {
            libraryRepository.save(new Library(
                    updatingLibrary.get(0).getId(),
                    library.getName(),
                    library.getAddress(),
                    library.getQuantityWorkers()));
            return libraryRepository.findAllByName(library.getName());
        }
        return updatingLibrary;
    }
}
