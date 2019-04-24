package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.AdditionalApartmentServiceDAO;
import com.gmail.hotelbooking.model.AdditionalApartmentServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalApartmentServiceImpl implements AdditionalApartmentService {

    private AdditionalApartmentServiceDAO additionalApartmentServiceDAO;

    @Autowired
    public AdditionalApartmentServiceImpl(AdditionalApartmentServiceDAO additionalApartmentServiceDAO) {
        this.additionalApartmentServiceDAO = additionalApartmentServiceDAO;
    }

    @Override
    public List<AdditionalApartmentServiceEntity> additionalApartmentServiceList() {
        return additionalApartmentServiceDAO.findAll();
    }

    @Override
    public Optional<AdditionalApartmentServiceEntity> findOne(Long id) {
        return additionalApartmentServiceDAO.findById(id);
    }
}
