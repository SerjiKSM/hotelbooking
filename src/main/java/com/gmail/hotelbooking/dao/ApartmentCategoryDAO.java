package com.gmail.hotelbooking.dao;

import com.gmail.hotelbooking.model.ApartmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentCategoryDAO extends JpaRepository<ApartmentCategory, Long> {
}
