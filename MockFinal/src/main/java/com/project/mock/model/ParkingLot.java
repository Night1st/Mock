package com.project.mock.model;

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

@Table(name = "ParkingLot")
@Entity

public class ParkingLot {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARKINGLOT_SEQ")
	@SequenceGenerator(name="PARKINGLOT_SEQ", sequenceName="PARKINGLOT_SEQ", allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	private int parkArea;
	
	private String parkName;
	
	private String parkPlace;
	
	private Long parkPrice;
	
	private String parkStatus;

	@OneToMany(mappedBy = "parkingLot", fetch = FetchType.LAZY)
	private List<Car> cars = new ArrayList<Car>();

	public ParkingLot() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getParkArea() {
		return parkArea;
	}

	public void setParkArea(int parkArea) {
		this.parkArea = parkArea;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkPlace() {
		return parkPlace;
	}

	public void setParkPlace(String parkPlace) {
		this.parkPlace = parkPlace;
	}

	public Long getParkPrice() {
		return parkPrice;
	}

	public void setParkPrice(Long parkPrice) {
		this.parkPrice = parkPrice;
	}

	public String getParkStatus() {
		return parkStatus;
	}

	public void setParkStatus(String parkStatus) {
		this.parkStatus = parkStatus;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
}
