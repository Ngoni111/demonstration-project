package com.ngonidzashemusiiwa.demo.project.demonstrationproject.item;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
	
	@Past(message="The Year of manufacture should be in the Past")
	private LocalDate yearOfManufacture;
	
	@Size(min = 1, message = "Country is blank, please fill in..")
	private String country;
	
	@NotNull(message = "Consumption should not be left blank")
	private Integer consumption;
	
	
	

	public Item(Integer id, @Size(min = 3, message = "Make is empty, please  fill in.") String make,
			@Size(min = 1, message = "Model is empty, please fill in.") String model,
			@Past(message = "The Year of manufacture should be in the future") LocalDate yearOfManufacture,
			@Size(min = 1, message = "Country is blank, please fill in..") String country, Integer consumption) {
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

	public Integer getConsumption() {
		return consumption;
	}

	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", make=" + make + ", model=" + model + ", yearOfManufacture=" + yearOfManufacture
				+ ", country=" + country + ", consumption=" + consumption + "Litres]";
	}
	

}
