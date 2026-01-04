//package com.res.controller;
//
//import com.res.entity.User;
//import com.res.service.UserService;
//
//import jakarta.servlet.http.HttpSession;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/users")
//@CrossOrigin(origins = "*") // allow frontend requests
//public class UserController {
//
//    private final UserService us;
//
//    public UserController(UserService us) {
//        this.us = us;
//    }
//
//    // Register a new user
//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        return us.registerUser(user);
//    }
//
//    // Reset password
//    @PutMapping("/reset-password")
//    public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
//        boolean updated = us.resetPassword(email, newPassword);
//        return updated ? "Password reset successful!" : "User not found!";
//    }
//    @GetMapping("/current")
//    public User getCurrentUser(HttpSession session) {
//        // Assuming you stored the User object in session after login
//        User user = (User) session.getAttribute("loggedInUser");
//        if (user != null) {
//            user.setPassword(null); // Do not expose password
//        }
//        return user; // Returns null if not logged in
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
//        String email = loginData.get("email");
//        String password = loginData.get("password");
//
//        Optional<User> userOpt = us.login(email, password); // your service
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            Map<String, String> response = new HashMap<>();
//            response.put("username", user.getUsername()); // store full name
//            response.put("email", user.getEmail());
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                                 .body(Map.of("message", "Invalid email or password"));
//        }
//    }
//
//    @GetMapping("/logout")
//    public void logout(HttpSession session) {
//        session.invalidate();
//    }
//    
//}
package com.res.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.res.entity.User;
import com.res.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        if (savedUser == null) {
            // Email already exists
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email is already registered");
        }
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Optional<User> userOpt = userService.findByEmailAndPassword(email, password);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("username", user.getUsername());
            response.put("email", user.getEmail());
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid email or password!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }
}
