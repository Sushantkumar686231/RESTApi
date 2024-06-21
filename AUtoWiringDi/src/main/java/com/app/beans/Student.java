package com.app.beans;

public class Student {


	private String name;
	private int roll_no;
	private Address address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Student(String name, int roll_no, Address address) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll_no=" + roll_no + ", address=" + address + "]";
	}
	
	
}
