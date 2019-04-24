package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments_category")
public class ApartmentCategory extends AbstractPersistable<Long> {

    private String title;

    @OneToMany(targetEntity = AvailableApartment.class, mappedBy = "apartmentsCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AvailableApartment> availableApartments;

    public ApartmentCategory() {
    }

    public ApartmentCategory(String title, Set<AvailableApartment> availableApartments) {
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
