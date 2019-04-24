package com.gmail.hotelbooking.dao;

import com.gmail.hotelbooking.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Long id);
}
