package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "additional_apartments_service")
public class AdditionalApartmentServiceEntity extends AbstractPersistable<Long> {

    private String title;

    @OneToOne(mappedBy = "additionalApartmentServiceEntity", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private AdditionalApartmentServicePrice additionalApartmentServicePrice;

    @OneToMany(targetEntity = Order.class, mappedBy = "additionalApartmentServiceEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> order;

    public AdditionalApartmentServiceEntity() {
    }

    public AdditionalApartmentServiceEntity(String title, AdditionalApartmentServicePrice additionalApartmentServicePrice, Set<Order> order) {
        this.title = title;
        this.additionalApartmentServicePrice = additionalApartmentServicePrice;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AdditionalApartmentServicePrice getAdditionalApartmentServicePrice() {
        return additionalApartmentServicePrice;
    }

    public void setAdditionalApartmentServicePrice(AdditionalApartmentServicePrice additionalApartmentServicePrice) {
        this.additionalApartmentServicePrice = additionalApartmentServicePrice;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
