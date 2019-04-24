package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "additional_apartments_service_price")
public class AdditionalApartmentServicePrice extends AbstractPersistable<Long> {

    private Double value;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_additional_apartments_service")
    private AdditionalApartmentServiceEntity additionalApartmentServiceEntity;

    public AdditionalApartmentServicePrice() {

    }

    public AdditionalApartmentServicePrice(Double value, AdditionalApartmentServiceEntity additionalApartmentServiceEntity) {
        this.value = value;
        this.additionalApartmentServiceEntity = additionalApartmentServiceEntity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public AdditionalApartmentServiceEntity getAdditionalApartmentServiceEntity() {
        return additionalApartmentServiceEntity;
    }

    public void setAdditionalApartmentServiceEntity(AdditionalApartmentServiceEntity additionalApartmentServiceEntity) {
        this.additionalApartmentServiceEntity = additionalApartmentServiceEntity;
    }
}
