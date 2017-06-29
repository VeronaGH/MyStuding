package com.testpro.library.domain.service;

import com.testpro.library.domain.model.PublishingHouse;
import com.testpro.library.domain.mongodb.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the PublishingHouse DB
 */
@Service
public class PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    /**
     * Save method
     *
     * @param publishingHouse class
     * @return PublishingHouse class
     */
    public PublishingHouse storePublishingHouse(PublishingHouse publishingHouse) {
        PublishingHouse existPublishingHouse = publishingHouseRepository.findByNameAndAddress(
                publishingHouse.getName(),
                publishingHouse.getAddress());
        if (existPublishingHouse != null) {
            return existPublishingHouse;
        }
        return publishingHouseRepository.save(publishingHouse);
    }

    /**
     * Delete method
     *
     * @param publishingHouse class
     * @return List<PublishingHouse> class
     */
    public List<PublishingHouse> deletePublishingHouse(PublishingHouse publishingHouse) {
        PublishingHouse existPublishingHouse = publishingHouseRepository.findByNameAndAddress(
                publishingHouse.getName(),
                publishingHouse.getAddress());
        if (existPublishingHouse != null) {
            return publishingHouseRepository.deleteByNameAndAddress(
                    publishingHouse.getName(),
                    publishingHouse.getAddress());
        }
        return null;
    }

    /**
     * Search method, try to find results firstly by name and address, if result is blank try find entity witch contain
     * name or address, if not sufficient parameters try to find with partial parameters.
     *
     * @param publishingHouse class
     * @return List<PublishingHouse> class
     */
    public List<PublishingHouse> findPublishingHouse(PublishingHouse publishingHouse) {
        List<PublishingHouse> searchPublishingHouseList = new ArrayList<PublishingHouse>();
        if ((publishingHouse.getName() != null) && (publishingHouse.getAddress() != null)) {
            PublishingHouse searchPublishingHouse = publishingHouseRepository.findByNameAndAddress(
                    publishingHouse.getName(),
                    publishingHouse.getAddress());
            if (searchPublishingHouse == null) {
                searchPublishingHouseList = publishingHouseRepository.findAllByNameOrAddress(
                        publishingHouse.getName(),
                        publishingHouse.getAddress());
            } else {
                searchPublishingHouseList.add(searchPublishingHouse);
            }
            return searchPublishingHouseList;
        }
        if (publishingHouse.getName() != null) {
            searchPublishingHouseList = publishingHouseRepository.findAllByName(publishingHouse.getName());
            return searchPublishingHouseList;
        }
        if (publishingHouse.getAddress() != null) {
            searchPublishingHouseList = publishingHouseRepository.findAllByAddress(publishingHouse.getAddress());
            return searchPublishingHouseList;
        }
        return publishingHouseRepository.findAll();
    }

    /**
     * This method look throw the PublishingHouse DB and try to find single entity by name and address
     * if find - change other params
     *
     * @param publishingHouse class
     * @return List<PublishingHouse>
     */
    public PublishingHouse updatePublishingHouse (PublishingHouse publishingHouse){
        PublishingHouse updatingPublishingHouse = publishingHouseRepository.findByNameAndAddress(
                publishingHouse.getName(),
                publishingHouse.getAddress());
        if (updatingPublishingHouse != null) {
            return publishingHouseRepository.save(new PublishingHouse(
                    updatingPublishingHouse.getId(),
                    publishingHouse.getName(),
                    publishingHouse.getAddress(),
                    publishingHouse.getPhone(),
                    publishingHouse.getContact()));
        }
        return null;
    }
}
