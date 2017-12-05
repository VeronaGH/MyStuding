package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.LibraryDTO;
import com.testpro.library.domain.model.Library;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Library
 */
@Component
public class LibraryConverter {

    /**
     * Method for converting of single LibraryDTO to Library
     *
     * @return Library
     */
    public Library convertToLibrary(LibraryDTO libraryDTO) {
        return new Library(
                0,
                libraryDTO.getName(),
                libraryDTO.getAddress(),
                libraryDTO.getQuantityWorkers());
    }

    /**
     * Method for converting of single Library to LibraryDTO
     *
     * @param library class
     * @return LibraryDTO
     */
    public LibraryDTO convertToLibraryDTO(Library library) {
        if (library == null) {
            return null;
        }
        return new LibraryDTO(
                library.getName(),
                library.getAddress(),
                library.getQuantityWorkers());
    }

    /**
     * Method for converting of List<Library> to List<LibraryDTO>
     *
     * @param libraryList List<Library>
     * @return List<LibraryDTO>
     */
    public List<LibraryDTO> convertToLibraryDTOList(List<Library> libraryList) {
        List<LibraryDTO> librariesDTO = new ArrayList<LibraryDTO>();
        for (Library libraryIterator : libraryList) {
            librariesDTO.add(convertToLibraryDTO(libraryIterator));
        }
        return librariesDTO;
    }

}
