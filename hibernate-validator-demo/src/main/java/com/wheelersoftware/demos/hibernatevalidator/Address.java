package com.wheelersoftware.demos.hibernatevalidator;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Pattern;

public class Address {
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;

	@NotEmpty
	@Length(max = 40)
	public String getStreet1() {
		return street1;
	}
	
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	// No validation constraints
	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@NotEmpty
	@Length(max = 40)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@NotEmpty
	@Length(max = 3)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@NotEmpty
	@Length(min = 5, max = 5, message = "{zip.length}")
	@Pattern(regex = "[0-9]+")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
