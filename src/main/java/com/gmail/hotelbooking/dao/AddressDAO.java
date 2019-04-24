package com.gmail.hotelbooking.dao;

import com.gmail.hotelbooking.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Long> {
}
