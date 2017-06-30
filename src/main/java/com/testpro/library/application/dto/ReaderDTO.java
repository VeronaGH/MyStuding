package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.Reader;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Pigas on 30.06.2017.
 */
public class ReaderDTO implements Serializable{

    public ReaderDTO() {
    }

    public ReaderDTO(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

}
