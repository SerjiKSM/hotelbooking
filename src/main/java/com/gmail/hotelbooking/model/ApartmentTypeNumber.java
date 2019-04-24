package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "apartments_type_number")
public class ApartmentTypeNumber extends AbstractPersistable<Long> {

    private String title;

    @OneToMany(targetEntity = AvailableApartment.class, mappedBy = "apartmentTypeNumber")
    private Set<AvailableApartment> availableApartments;

    public ApartmentTypeNumber() {

    }

    public ApartmentTypeNumber(String title, Set<AvailableApartment> availableApartments) {
        this.title = title;
        this.availableApartments = availableApartments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<AvailableApartment> getAvailableApartments() {
        return availableApartments;
    }

    public void setAvailableApartments(Set<AvailableApartment> availableApartments) {
        this.availableApartments = availableApartments;
    }
}

