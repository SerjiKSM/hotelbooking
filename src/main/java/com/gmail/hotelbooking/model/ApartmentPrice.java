package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments_price")
public class ApartmentPrice extends AbstractPersistable<Long> {

    private Double value;

    @OneToMany(targetEntity = AvailableApartment.class, mappedBy = "apartmentPrice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AvailableApartment> availableApartments;

    public ApartmentPrice() {
    }

    public ApartmentPrice(Double value, Set<AvailableApartment> availableApartments) {
        this.value = value;
        this.availableApartments = availableApartments;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<AvailableApartment> getAvailableApartments() {
        return availableApartments;
    }

    public void setAvailableApartments(Set<AvailableApartment> availableApartments) {
        this.availableApartments = availableApartments;
    }
}
