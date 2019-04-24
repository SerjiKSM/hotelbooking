package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.OrderDAO;
import com.gmail.hotelbooking.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findAllByUserId(Long id) {
        return orderDAO.findAllByUserId(id);
    }

    @Override
    public Order save(Order order) {
        return orderDAO.save(order);
    }
}
