package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for LibraryController
 */

public final class LibraryDTO implements Serializable {

    public LibraryDTO() {
    }

    public LibraryDTO(String name, String address, int quantityWorkers) {
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
