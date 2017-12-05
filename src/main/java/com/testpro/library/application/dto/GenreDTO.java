package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for GenreController
 */
public class GenreDTO implements Serializable {

    public GenreDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public GenreDTO() {
    }

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25, min = 3)
    private String name;

    @JsonProperty(value = "description")
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
