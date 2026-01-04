package com.res.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User customer;

	private LocalDateTime reservationDateTime;

	private int noOfPeople;

	// Constructors
	public Reservation() {
	}

	public Reservation(Long reservationId, User customer, LocalDateTime reservationDateTime, int noOfPeople) {
		this.reservationId = reservationId;
		this.customer = customer;
		this.reservationDateTime = reservationDateTime;
		this.noOfPeople = noOfPeople;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public LocalDateTime getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(LocalDateTime reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
}
