package com.app.beans;

public class Address {

	private int houseNo;
	private String Street;
	private long pincode;
	
	
	public Address(int houseNo, String street, long pincode) {
		super();
		this.houseNo = houseNo;
		Street = street;
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", Street=" + Street + ", pincode=" + pincode + "]";
	}
	
	
	
}
