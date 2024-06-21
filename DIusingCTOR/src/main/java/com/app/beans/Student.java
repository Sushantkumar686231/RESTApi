package com.app.beans;

public class Student {

	private String Sname;
	private int RollNo;
	private float marks;
	private Address address;
	
   
	public Student(String sname, int rollNo, float marks, Address address) {
		super();
		Sname = sname;
		RollNo = rollNo;
		this.marks = marks;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [Sname=" + Sname + ", RollNo=" + RollNo + ", marks=" + marks + ", address=" + address + "]";
	}
	
	
}
