package com.gmail.hotelbooking.service;

import com.gmail.hotelbooking.dao.UserDAO;
import com.gmail.hotelbooking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> userList() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        userDAO.deleteById(id);
        return "{'message': 'User deleted!'}";
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
