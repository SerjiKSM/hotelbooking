package com.gmail.hotelbooking.dao;

import com.gmail.hotelbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
