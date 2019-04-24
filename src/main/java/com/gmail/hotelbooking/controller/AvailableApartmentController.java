package com.gmail.hotelbooking.controller;

import com.gmail.hotelbooking.model.AdditionalApartmentServiceEntity;
import com.gmail.hotelbooking.model.AvailableApartment;
import com.gmail.hotelbooking.model.Order;
import com.gmail.hotelbooking.model.User;
import com.gmail.hotelbooking.service.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class AvailableApartmentController {

    private AvailableApartmentService availableApartmentService;
    private AdditionalApartmentService additionalApartmentService;
    private UserService userService;
    private ApartmentCategoryService apartmentCategoryService;
    private OrderService orderService;

    @Autowired
    public AvailableApartmentController(AvailableApartmentService availableApartmentService, AdditionalApartmentService additionalApartmentService,
                                        UserService userService,
                                        ApartmentCategoryService apartmentCategoryService,
                                        OrderService orderService) {
        this.availableApartmentService = availableApartmentService;
        this.additionalApartmentService = additionalApartmentService;
        this.userService = userService;
        this.apartmentCategoryService = apartmentCategoryService;
        this.orderService = orderService;
    }

    @RequestMapping("/list-available-numbers")
    public String listAvailableNumbers(Model model) {
        model.addAttribute("availableApartments", availableApartmentService.listAvailable());
        model.addAttribute("categories", apartmentCategoryService.listApartmentCategory());

        return "list-available-numbers";
    }

    @RequestMapping("/form-reservation")
    public String showFormReservation(Model model,
                                      @RequestParam(value="id") long id) {

        String dateFrom = availableApartmentService.findOne(id).get().getFormatDateFrom("YYYY-MM-DD");
        String dateTo = availableApartmentService.findOne(id).get().getFormatDateTo("YYYY-MM-DD");
        Long daysBetweenDates = availableApartmentService.getDaysBetweenDates(dateFrom, dateTo);

        model.addAttribute("availableApartment", availableApartmentService.findOne(id).get());
        model.addAttribute("additionalApartmentServices", additionalApartmentService.additionalApartmentServiceList());
        model.addAttribute("users", userService.userList());
        model.addAttribute("daysBetweenDates", daysBetweenDates);

        JSONObject json = new JSONObject();
        json.put("urlFindAdditionalApartmentServicePrice", "find-additional-apartment-service-price");

        model.addAttribute("configDataJson", json);

        return "form-reservation";
    }

    @RequestMapping("/find-additional-apartment-service-price")
    @ResponseBody
    public String findAdditionalApartmentServicePrice(Model model,
                                                      @RequestParam(value="id") Long id) {

        JSONObject json = new JSONObject();
        if (id == null) {
            json.put("additionalApartmentServicePrice", null);
        } else {
            json.put("additionalApartmentServicePrice", additionalApartmentService.findOne(id).get()
                    .getAdditionalApartmentServicePrice().getValue());
        }

        return String.valueOf(json);
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.POST)
    public ModelAndView addBooking(
            @PathVariable("id") long id,
            @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo,
            @RequestParam(value="additionalApartmentService") Long additionalApartmentServiceId,
            @RequestParam(value="user") Long userId,
            @RequestParam(value="total") Double total
    ) {

        AvailableApartment availableApartment = availableApartmentService.findOne(id).get();
        availableApartment.setAvailable(false);

        User user = userService.findOne(userId).get();
        Order order = new Order();
        order.setAvailableApartments(availableApartment);
        if (additionalApartmentServiceId != null) {
            AdditionalApartmentServiceEntity additionalApartmentServiceEntity = additionalApartmentService.findOne(additionalApartmentServiceId).get();
            order.setAdditionalApartmentServiceEntity(additionalApartmentServiceEntity);
        }
        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);
        order.setUser(user);
        order.setTotal(total);

        orderService.save(order);
        availableApartmentService.save(availableApartment);

        return new ModelAndView("redirect:/list-available-numbers");
    }

    @RequestMapping(value = "/find-available-apartment-by-dates")
    public String findAllAvailableApartmentByDateFromAndDateTo( Model model,
                                                                @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
                                                                @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo) {

        model.addAttribute("availableApartments", availableApartmentService.
                listBetweenDateFromAndDateTo(dateFrom, dateTo));
        model.addAttribute("categories", apartmentCategoryService.listApartmentCategory());

        return "list-available-numbers";

    }
}
