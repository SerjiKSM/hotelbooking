package com.gmail.hotelbooking.controller;

import com.gmail.hotelbooking.service.ApartmentCategoryService;
import com.gmail.hotelbooking.service.AvailableApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    private AvailableApartmentService availableApartmentService;
    private ApartmentCategoryService apartmentCategoryService;

    @Autowired
    public CategoryController(AvailableApartmentService availableApartmentService,
                              ApartmentCategoryService apartmentCategoryService) {
        this.availableApartmentService = availableApartmentService;
        this.apartmentCategoryService = apartmentCategoryService;
    }

    @RequestMapping(value = "/filter-category")
    public String findAllAvailableApartmentByDateFromAndDateTo(Model model,
                                                               @RequestParam(value="filterCategory") Long filterCategoryId) {

        model.addAttribute("availableApartments", availableApartmentService.findByCategory(filterCategoryId));
        model.addAttribute("categories", apartmentCategoryService.listApartmentCategory());

        return "list-available-numbers";

    }

}
