package com.gmail.hotelbooking.controller;

import com.gmail.hotelbooking.model.User;
import com.gmail.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form-add")
    public String formAdd(Model model) {

        return "/user/form-add";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", userService.userList());

        return "/user/list";
    }

    @RequestMapping("/list/{id}")
    public Optional<User> findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam(value="user") String userName) {
        User user = new User();
        user.setUsername(userName);
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
