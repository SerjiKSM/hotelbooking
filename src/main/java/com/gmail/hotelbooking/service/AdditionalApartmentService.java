package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.model.AdditionalApartmentServiceEntity;

import java.util.List;
import java.util.Optional;

public interface AdditionalApartmentService {
    List<AdditionalApartmentServiceEntity> additionalApartmentServiceList();
    Optional<AdditionalApartmentServiceEntity> findOne(Long id);
}
