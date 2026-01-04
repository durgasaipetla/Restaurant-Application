package com.res.controller;

import org.springframework.web.bind.annotation.*;

import com.res.entity.Reservation;
import com.res.entity.User;
import com.res.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService rs;

    public ReservationController(ReservationService rs) {
        this.rs = rs;
    }

    // Make a reservation
    @PostMapping("/make")
    public Reservation makeReservation(@RequestBody Reservation reservation) {
        return rs.makeReservation(reservation);
    }

    // Get reservations by user
    @GetMapping("/user")
    public List<Reservation> getReservationsByUser(@RequestBody User user) {
        return rs.getReservationsByUser(user);
    }

    // Cancel reservation
    @DeleteMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable Long id) {
        rs.cancelReservation(id);
        return "Reservation Cancelled Successfully";
    }
}
