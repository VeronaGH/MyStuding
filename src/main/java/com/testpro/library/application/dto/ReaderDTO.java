package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Reader;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for ReaderController
 */
public class ReaderDTO implements Serializable {

    public ReaderDTO(String name, String surname, String address, Reader.State state) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.state = state;
    }

    public ReaderDTO() {
    }

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25, min = 2)
    private String name;

    @JsonProperty(value = "surname")
    @NotBlank
    @Size(max = 25, min = 2)
    private String surname;

    @JsonProperty(value = "address")
    @Size(max = 25, min = 2)
    private String address;

    @JsonProperty(value = "state")
    @NotBlank
    private Reader.State state;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public Reader.State getState() {
        return state;
    }
}
