package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.PublishingHouseDTO;
import com.testpro.library.domain.model.PublishingHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity PublishingHouse
 */
public class PublishingHouseConverter {
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
    public PublishingHouse convertToPublishHouse(PublishingHouseDTO publishingHouseDTO) {
        return new PublishingHouse(
                0,
                publishingHouseDTO.getName(),
                publishingHouseDTO.getAddress(),
                publishingHouseDTO.getPhone(),
                publishingHouseDTO.getContact());
    }

    /**
     * Method for converting of single List<publishingHouseDTO> to List<publishingHouse>
     *
     * @param publishingHouseList class
     * @return List<publishingHouseDTO>
     */
    public List<PublishingHouseDTO> convertToPublishingHouseDTOList(List<PublishingHouse> publishingHouseList) {
        if (publishingHouseList == null) {
            return null;
        }
        List<PublishingHouseDTO> publishingHouseDTOList = new ArrayList<PublishingHouseDTO>();
        for (PublishingHouse publishingHouse : publishingHouseList) {
            publishingHouseDTOList.add(convertToPublishHouseDTO(publishingHouse));
        }
        return publishingHouseDTOList;
    }

}
