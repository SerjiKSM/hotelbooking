package com.gmail.hotelbooking.dao;

import com.gmail.hotelbooking.model.AvailableApartment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AvailableApartmentDAO extends JpaRepository<AvailableApartment, Long> {

    List<AvailableApartment> findAllByDateFromGreaterThanEqualAndDateToLessThanEqual(Date from, Date to);

    List<AvailableApartment> findAllByAvailableTrueAndDateFromGreaterThanEqualAndDateToLessThanEqual(Date from, Date to);

    List<AvailableApartment> findAllByApartmentsCategoryId(Long id);


    List<AvailableApartment> findAllByAvailableTrueAndApartmentsCategoryId(Long id);

    List<AvailableApartment> findAllByAvailable(Boolean available, Sort sort);
}
