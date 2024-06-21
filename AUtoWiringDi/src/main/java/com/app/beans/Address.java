package com.app.beans;

public class Address {

	private int houseNo;
	private String street;
	private int pincode;
	
	public Address(int houseNo, String street, int pincode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.pincode = pincode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	//setters
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
