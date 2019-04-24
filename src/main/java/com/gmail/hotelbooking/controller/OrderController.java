package com.gmail.hotelbooking.controller;

import com.gmail.hotelbooking.service.OrderService;
import com.gmail.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @RequestMapping("/list-orders")
    public String listOrders(Model model) {
        model.addAttribute("users", userService.userList());
        model.addAttribute("orders", orderService.findAll());

        return "list-orders";
    }

    @RequestMapping("/filter-user")
    public String userOrders(Model model,
                             @RequestParam(value="filterUser") Long userId) {
        model.addAttribute("users", userService.userList());
        model.addAttribute("orders", orderService.findAllByUserId(userId));

        return "list-orders";
    }
}
