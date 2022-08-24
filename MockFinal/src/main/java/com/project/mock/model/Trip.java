package com.project.mock.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "trip")
@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRIP_SEQ")
	@SequenceGenerator(name="TRIP_SEQ", sequenceName="TRIP_SEQ", allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	private int bookedTicketNumber;
	
	private String carType;
	
	private Date departureDate;
	
	private String departureTime;
	
	private String destination;
	
	private String driver;
	
	private int maximumOnlineTicketNumber;
	
	@OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	@OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
	private List<BookingOffice> bookingOffices = new ArrayList<BookingOffice>();

	public Trip() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBookedTicketNumber() {
		return bookedTicketNumber;
	}

	public void setBookedTicketNumber(int bookedTicketNumber) {
		this.bookedTicketNumber = bookedTicketNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getMaximumOnlineTicketNumber() {
		return maximumOnlineTicketNumber;
	}

	public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<BookingOffice> getBookingOffices() {
		return bookingOffices;
	}

	public void setBookingOffices(List<BookingOffice> bookingOffices) {
		this.bookingOffices = bookingOffices;
	}
	
	
}
