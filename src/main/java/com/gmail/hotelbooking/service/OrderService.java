package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    List<Order> findAllByUserId(Long id);

    Order save(Order order);
}
