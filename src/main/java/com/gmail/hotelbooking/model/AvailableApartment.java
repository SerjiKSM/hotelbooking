package com.gmail.hotelbooking.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "available_apartments")
public class AvailableApartment extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_apartment_category")
    private ApartmentCategory apartmentsCategory;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    @ManyToOne
    @JoinColumn(name = "id_apartment_type_number")
    private ApartmentTypeNumber apartmentTypeNumber;

    @ManyToOne
    @JoinColumn(name = "id_apartment_price")
    private ApartmentPrice apartmentPrice;

    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    private Boolean available;

    @OneToMany(targetEntity = Order.class, mappedBy = "availableApartments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> order;

    public AvailableApartment() {

    }

    public AvailableApartment(Hotel hotel, ApartmentCategory apartmentsCategory, int apartmentNumber, ApartmentTypeNumber apartmentTypeNumber, ApartmentPrice apartmentPrice, Date dateFrom, Date dateTo, Boolean available, Set<Order> order) {
        this.hotel = hotel;
        this.apartmentsCategory = apartmentsCategory;
        this.apartmentNumber = apartmentNumber;
        this.apartmentTypeNumber = apartmentTypeNumber;
        this.apartmentPrice = apartmentPrice;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.available = available;
        this.order = order;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ApartmentTypeNumber getApartmentTypeNumber() {
        return apartmentTypeNumber;
    }

    public void setApartmentTypeNumber(ApartmentTypeNumber apartmentTypeNumber) {
        this.apartmentTypeNumber = apartmentTypeNumber;
    }

    public ApartmentCategory getApartmentsCategory() {
        return apartmentsCategory;
    }

    public void setApartmentsCategory(ApartmentCategory apartmentsCategory) {
        this.apartmentsCategory = apartmentsCategory;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public ApartmentPrice getApartmentPrice() {
        return apartmentPrice;
    }

    public void setApartmentPrice(ApartmentPrice apartmentPrice) {
        this.apartmentPrice = apartmentPrice;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
