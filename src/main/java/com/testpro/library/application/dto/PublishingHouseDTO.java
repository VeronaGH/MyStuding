package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Data transfer object class for parsing incoming data for PublishHouseController
 */
public final class PublishingHouseDTO implements Serializable {

    public PublishingHouseDTO(String name, String address, String phone, String contact) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
    }

    public PublishingHouseDTO() {
    }

    @JsonProperty(value = "name")
    @NotBlank
    @Size(max = 25, min = 3)
    private String name;

    @JsonProperty(value = "address")
    @NotBlank
    @Size(max = 50, min = 20)
    private String address;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "contact")
    private String contact;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getContact() {
        return contact;
    }
}
