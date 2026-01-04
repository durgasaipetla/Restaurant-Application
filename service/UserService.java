package com.res.service;

import java.util.Optional;

import com.res.entity.User;

public interface UserService {
	User registerUser(User user);
    Optional<User> findByEmailAndPassword(String username, String password);
    boolean resetPassword(String email, String newPassword);
}
