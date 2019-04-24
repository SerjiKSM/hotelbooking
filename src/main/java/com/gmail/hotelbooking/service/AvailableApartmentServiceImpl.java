package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.AvailableApartmentDAO;
import com.gmail.hotelbooking.model.AvailableApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AvailableApartmentServiceImpl implements AvailableApartmentService {

    private AvailableApartmentDAO availableApartmentDAO;

    @Autowired
    public AvailableApartmentServiceImpl(AvailableApartmentDAO availableApartmentDAO) {
        this.availableApartmentDAO = availableApartmentDAO;
    }

    @Override
    public List<AvailableApartment> list() {
        return availableApartmentDAO.findAll(orderByHotelTitleAndApartmentNumber());
    }

    @Override
    public List<AvailableApartment> listAvailable() {
        return availableApartmentDAO.findAllByAvailable(true, orderByHotelTitleAndApartmentNumber());
    }

    private Sort orderByHotelTitleAndApartmentNumber() {
        return new Sort(Sort.Direction.ASC, "hotel")
                .and(new Sort(Sort.Direction.ASC, "apartmentNumber"));
    }

    @Override
    public Optional<AvailableApartment> findOne(Long id) {
        return availableApartmentDAO.findById(id);
    }

    @Override
    public List<AvailableApartment> findByCategory(Long id) {
        return availableApartmentDAO.findAllByAvailableTrueAndApartmentsCategoryId(id);
    }

    @Override
    public AvailableApartment save(AvailableApartment AvailableApartment) {
        return availableApartmentDAO.save(AvailableApartment);
    }

    public List<AvailableApartment> listBetweenDateFromAndDateTo(Date from, Date to) {
        return availableApartmentDAO.findAllByAvailableTrueAndDateFromGreaterThanEqualAndDateToLessThanEqual(from, to);
    }

    @Override
    public Long getDaysBetweenDates(String dateFrom, String dateTo) {
        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(dateFrom);
        LocalDate dateAfter = LocalDate.parse(dateTo);

        //calculating number of days in between
        long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        return daysBetween;
    }

}
