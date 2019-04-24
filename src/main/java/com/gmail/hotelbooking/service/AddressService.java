package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> addressList();
    Optional<Address> findOne(Long id);
    Address addAddress(Address address);
    String deleteAddress(Long id);
}
