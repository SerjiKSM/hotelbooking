package com.gmail.hotelbooking.controller;

import com.gmail.hotelbooking.dao.UserDAO;
import com.gmail.hotelbooking.model.Address;
import com.gmail.hotelbooking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public AddressController() {

    }

    @GetMapping("/list")
    public String addressList(Model model) {
        model.addAttribute("addresses", addressService.addressList());
        return "/address/list";
    }

    @RequestMapping("/list/{id}")
    public Optional<Address> findOne(@PathVariable Long id) {
        return addressService.findOne(id);
    }

    @RequestMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @RequestMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }

}
