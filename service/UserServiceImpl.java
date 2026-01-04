package com.res.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.res.entity.User;
import com.res.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository ur;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository ur, PasswordEncoder passwordEncoder) {
        this.ur = ur;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        Optional<User> existingUser = ur.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return null; // Email already registered
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ur.save(user);
    }


    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        Optional<User> userOpt = ur.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    @Override
    public boolean resetPassword(String email, String newPassword) {
        Optional<User> userOpt = ur.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            ur.save(user);
            return true;
        }
        return false;
    }
}
