package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hotels")
public class Hotel extends AbstractPersistable<Long> {

    private String title;

    private String description;

    @OneToMany(targetEntity = AvailableApartment.class, mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AvailableApartment> availableApartments;

    public Hotel() {
    }

    public Hotel(String title, String description, Set<AvailableApartment> availableApartments) {
        this.title = title;
        this.description = description;
        this.availableApartments = availableApartments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailableApartments(Set<AvailableApartment> availableApartments) {
        this.availableApartments = availableApartments;
    }

    public Set<AvailableApartment> getAvailableApartments() {
        return availableApartments;
    }
}
