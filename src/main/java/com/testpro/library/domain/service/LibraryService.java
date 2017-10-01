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
    public Library storeLibrary(Library library) {
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
        if (!deleteLibrary.isEmpty()) {
            return deleteLibrary.get(0);
        }
        return null;
    }

    /**
     * Find entity by its name or address, or return all DB
     *
     * @param library class
     * @return List<Library>
     */
    public List<Library> findLibrary(Library library) {
        List<Library> libraryList;
        if ((library.getName() != null) && (library.getAddress() != null)) {
            libraryList = libraryRepository.findAllByNameAndAddress(library.getName(), library.getAddress());
            if (libraryList.isEmpty()) {
                libraryList = libraryRepository.findAllByNameOrAddress(library.getName(), library.getAddress());
            }
            return libraryList;
        }
        if (library.getName() != null) {
            libraryList = libraryRepository.findAllByName(library.getName());
            return libraryList;
        }
        if (library.getAddress() != null) {
            libraryList = libraryRepository.findAllByAddress(library.getAddress());
            return libraryList;
        }
        return libraryRepository.findAll();
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

    /**
     * Return Library by it's ID
     *
     * @param library Library
     * @return int ID
     */
    public int returnLibraryId(Library library) {
        List<Library> searchLibrary = libraryRepository.findAllByNameAndAddress(library.getName(), library.getAddress());
        if (searchLibrary.size() == 1) {
            return searchLibrary.get(0).getId();
        } else return -1;
    }

    /**
     * Return Library by it's ID
     *
     * @param id int
     * @return Library
     */
    public Library findLibraryById(int id) {
        Library library = libraryRepository.findOneById(id);
        if (library != null) {
            return library;
        }
        return null;
    }
}
