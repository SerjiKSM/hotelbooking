package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "id_available_apartments")
    private AvailableApartment availableApartments;

    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_additional_apartments_servive")
    private AdditionalApartmentServiceEntity additionalApartmentServiceEntity;

    public Order() {
    }

    public Order(AvailableApartment availableApartments, Date dateFrom, Date dateTo, User user, Double total, AdditionalApartmentServiceEntity additionalApartmentServiceEntity) {
        this.availableApartments = availableApartments;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.user = user;
        this.total = total;
        this.additionalApartmentServiceEntity = additionalApartmentServiceEntity;
    }

    public AvailableApartment getAvailableApartments() {
        return availableApartments;
    }

    public void setAvailableApartments(AvailableApartment availableApartments) {
        this.availableApartments = availableApartments;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public AdditionalApartmentServiceEntity getAdditionalApartmentServiceEntity() {
        return additionalApartmentServiceEntity;
    }

    public void setAdditionalApartmentServiceEntity(AdditionalApartmentServiceEntity additionalApartmentServiceEntity) {
        this.additionalApartmentServiceEntity = additionalApartmentServiceEntity;
    }

    public String getFormatDateFrom(String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String dateFrom = format.format(getDateFrom());

        return dateFrom;
    }

    public String getFormatDateTo(String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String dateTo = format.format(getDateTo());

        return dateTo;
    }
}
