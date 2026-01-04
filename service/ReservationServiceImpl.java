 package com.res.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.res.entity.Reservation;
import com.res.entity.User;
import com.res.repository.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository rr;

	public ReservationServiceImpl(ReservationRepository rr) {
        this.rr = rr;
    }

	@Override
	public Reservation makeReservation(Reservation reservation) {
		return rr.save(reservation);
	}

	@Override
	public List<Reservation> getReservationsByUser(User user) {
		return rr.findByCustomer(user);
	}

	@Override
	public void cancelReservation(Long reservationId) {
		rr.deleteById(reservationId);
	}

}
