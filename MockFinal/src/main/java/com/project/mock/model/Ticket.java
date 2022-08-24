package com.project.mock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "ticket")
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_SEQ")
	@SequenceGenerator(name="TICKET_SEQ", sequenceName="TICKET_SEQ", allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	private String bookingTime;
	
	private String customerName;
	
	@ManyToOne
	@JoinColumn(name = "tripid")
	private Trip trip;
	
	@ManyToOne
	@JoinColumn(name = "licenseplate")
	private Car car;

	public Ticket() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
