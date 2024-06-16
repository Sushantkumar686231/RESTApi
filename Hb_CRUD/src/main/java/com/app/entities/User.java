package com.app.entities;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fName" ,length=20)
	private String firstName;
	
	@Column(name="lName" ,length=20)
	private String lastName;
	
	@Column(length=30, unique=true)
	private String email;
	
	@Column(length=20, unique=true)
	private String password;
	
	
	private LocalDate dob;
	
	@Column(name="phn_number", length=14,unique=true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Role" ,length=20)
	private Role role;
	
	@Lob
	private byte[] image;
	
	@Column(name="reg_Amount")
	private double regAmount;
	
	//CTOR
	public User() {
		super();
	}

	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, String phoneNumber,
			Role role, double regAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.regAmount = regAmount;
	}
	


	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", role=" + role
				+ ", image=" + Arrays.toString(image) + ", regAmount=" + regAmount + "]";
	}
	
	
	
	
}
