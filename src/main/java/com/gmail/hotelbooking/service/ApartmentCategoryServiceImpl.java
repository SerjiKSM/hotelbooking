package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.ApartmentCategoryDAO;
import com.gmail.hotelbooking.model.ApartmentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentCategoryServiceImpl implements ApartmentCategoryService {

    private ApartmentCategoryDAO apartmentCategoryDAO;

    @Autowired
    public ApartmentCategoryServiceImpl(ApartmentCategoryDAO apartmentCategoryDAO) {
        this.apartmentCategoryDAO = apartmentCategoryDAO;
    }

    @Override
    public List<ApartmentCategory> listApartmentCategory() {
        return apartmentCategoryDAO.findAll();
    }
}
