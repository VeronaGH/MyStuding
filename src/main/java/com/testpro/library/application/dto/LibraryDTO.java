package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for LibraryController
 */
public final class LibraryDTO implements Serializable {

    public LibraryDTO(String name, String address, int quantityWorkers) {
        this.name = name;
        this.address = address;
        this.quantityWorkers = quantityWorkers;
    }

    public LibraryDTO() {
    }

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25)
    private String name;

    @JsonProperty(value = "address")
    @NotBlank
    private String address;

    @JsonProperty(value = "quantityWorkers")
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

}
