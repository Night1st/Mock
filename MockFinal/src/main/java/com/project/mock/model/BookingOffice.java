package com.project.mock.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "bookingOffice")
@Entity
public class BookingOffice implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOKINGOFFICE_SEQ")
	@SequenceGenerator(name="BOOKINGOFFICE_SEQ", sequenceName="BOOKINGOFFICE_SEQ", allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	private Date endContractDeadline;
	
	private String officeName;
	
	private String officePhone;
	
	private String officePlace;
	
	private Long officePrice;
	
	private Date startContractDeadline;

	@ManyToOne
	@JoinColumn(name = "tripid")
	private Trip trip;

	public BookingOffice() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(Date endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public Long getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(Long officePrice) {
		this.officePrice = officePrice;
	}

	public Date getStartContractDeadline() {
		return startContractDeadline;
	}

	public void setStartContractDeadline(Date startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
}
