package com.testpro.library.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpro.library.domain.model.PublishingHouse;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object class for parsing incoming data for PublishHouseController
 */
public final class PublishingHouseDTO implements Serializable {

    public PublishingHouseDTO() {
    }

    private PublishingHouseDTO(String name, String address, String phone, String contact) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
    }

    /**
     * Method for converting of single publishingHouse to publishingHouseGTO
     *
     * @param publishingHouse class
     * @return publishingHouseDTO
     */
    public PublishingHouseDTO convertToPublishHouseDTO(PublishingHouse publishingHouse) {
        if (publishingHouse == null) {
            return null;
        }
        return new PublishingHouseDTO(
                publishingHouse.getName(),
                publishingHouse.getAddress(),
                publishingHouse.getPhone(),
                publishingHouse.getContact());
    }

    /**
     * Method for converting of single publishingHouseDTO to publishingHouse
     *
     * @return publishingHouse class
     */
    public PublishingHouse convertToPublishHouse() {
        return new PublishingHouse(0, this.name, this.address, this.phone, this.contact);
    }

    /**
     * Method for converting of single List<publishingHouseDTO> to List<publishingHouse>
     *
     * @param publishingHouseList class
     * @return List<publishingHouseDTO>
     */
    public List<PublishingHouseDTO> convertToPublishHouseDTOList(List<PublishingHouse> publishingHouseList) {
        if (publishingHouseList == null) {
            return null;
        }
        List<PublishingHouseDTO> publishingHouseDTOList = new ArrayList<PublishingHouseDTO>();
        for (PublishingHouse publishingHouse : publishingHouseList) {
            publishingHouseDTOList.add(convertToPublishHouseDTO(publishingHouse));
        }
        return publishingHouseDTOList;
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
