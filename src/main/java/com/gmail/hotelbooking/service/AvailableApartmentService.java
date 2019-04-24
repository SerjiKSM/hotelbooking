package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.model.AvailableApartment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AvailableApartmentService {
    List<AvailableApartment> list();

    List<AvailableApartment> listAvailable();

    List<AvailableApartment> listBetweenDateFromAndDateTo(Date from, Date to);

    Optional<AvailableApartment> findOne(Long id);

    List<AvailableApartment> findByCategory(Long id);

    AvailableApartment save(AvailableApartment AvailableApartment);

    Long getDaysBetweenDates(String dateFrom, String dateTo);
}
