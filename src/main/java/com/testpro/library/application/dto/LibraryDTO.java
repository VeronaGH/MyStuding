package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Library;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object class for parsing incoming data for LibraryController
 */
public final class LibraryDTO implements Serializable {

    public LibraryDTO() {
    }

    /**
     * Method for converting of single LibraryDTO to Library
     *
     * @param libraryDTO class
     * @return Library
     */
    public Library convertToLibrary(LibraryDTO libraryDTO) {
        return new Library(0, libraryDTO.getName(), libraryDTO.getAddress(), libraryDTO.getQuantityWorkers());
    }

    /**
     * Method for converting of single Library to LibraryDTO
     *
     * @param library class
     * @return LibraryDTO
     */
    public LibraryDTO convertToLibraryDTO(Library library) {
        return new LibraryDTO(library.getName(), library.getAddress(), library.getQuantityWorkers());
    }

    /**
     * Method for converting of List<Library> to List<LibraryDTO>
     *
     * @param libraryList List<Library>
     * @return List<LibraryDTO>
     */
    public List<LibraryDTO> convertToLibraryDTOMap(List<Library> libraryList) {
        List<LibraryDTO> librariesDTO = new ArrayList<LibraryDTO>();
        for (Library libraryIterator : libraryList) {
            librariesDTO.add(convertToLibraryDTO(libraryIterator));
        }
        return librariesDTO;
    }

    private LibraryDTO(String name, String address, int quantityWorkers) {
        this.name = name;
        this.address = address;
        this.quantityWorkers = quantityWorkers;
    }

    @JsonProperty
    @NotBlank
    @Size(max = 25)
    private String name;

    @JsonProperty
    @NotBlank
    private String address;

    @JsonProperty
    private int quantityWorkers;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getQuantityWorkers() {
        return quantityWorkers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setQuantityWorkers(int quantityWorkers) {
        this.quantityWorkers = quantityWorkers;
    }

}
