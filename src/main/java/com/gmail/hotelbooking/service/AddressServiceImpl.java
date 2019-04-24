package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.AddressDAO;
import com.gmail.hotelbooking.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public List<Address> addressList() {
        return addressDAO.findAll();
    }

    @Override
    public Optional<Address> findOne(Long id) {
        return addressDAO.findById(id);
    }

    @Override
    public Address addAddress(Address address) {
        return addressDAO.save(address);
    }

    @Override
    public String deleteAddress(Long id) {
        addressDAO.deleteById(id);
        return "{'message': 'Address deleted!'}";
    }
}
