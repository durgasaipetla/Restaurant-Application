package com.res.service;

import java.util.List;

import com.res.entity.Reservation;
import com.res.entity.User;

public interface ReservationService {
	Reservation makeReservation(Reservation reservation);
    List<Reservation> getReservationsByUser(User user);
    void cancelReservation(Long reservationId);

}
