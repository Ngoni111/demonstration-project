package com.ngonidzashemusiiwa.demo.project.demonstrationproject.item;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="item_details")
public class Item {
	
	
	
	protected Item() {
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Make is empty, please  fill in.")
	private String make;
	
	@Size(min = 1, message = "Model is empty, please fill in.")
	private String model;
	
	@Past(message="The Year of manufacture should be in the future")
	private LocalDate yearOfManufacture;
	
	@Size(min = 1, message = "Country is blank, please fill in..")
	private String country;
	
	@Size(min = 1, message = "Consumption is empty, please fill in.")
	private Long consumption;
	
	
	

	public Item(Integer id, @Size(min = 3, message = "Make is empty, please  fill in.") String make,
			@Size(min = 1, message = "Model is empty, please fill in.") String model,
			@Past(message = "The Year of manufacture should be in the future") LocalDate yearOfManufacture,
			@Size(min = 1, message = "Country is blank, please fill in..") String country,
			@Size(min = 1, message = "Consumption is empty, please fill in.") Long consumption) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.country = country;
		this.consumption = consumption;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(LocalDate yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getConsumption() {
		return consumption;
	}

	public void setConsumption(Long consumption) {
		this.consumption = consumption;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", make=" + make + ", model=" + model + ", yearOfManufacture=" + yearOfManufacture
				+ ", country=" + country + ", consumption=" + consumption + "Litres]";
	}
	

}
