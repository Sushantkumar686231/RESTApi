package com.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity class or say domain class
@Entity
@Table(name="products")
public class Products implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	//bean properties
	@Column(name="NAME" ,length=20)
	private String name;
	@Column(name="PRICE" ,length=20)
	private float price;
	@Column(name="QTY" ,length=20)
	private float qty;
	
	//default CTOR
	public Products() {
	
	}
	
	public Products(String name, float price, float qty) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	
	
	//getter setter


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}
	
	
	
}
