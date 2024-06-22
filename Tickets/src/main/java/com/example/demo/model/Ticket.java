package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(name="phnnumber", nullable=false, unique=true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Category",nullable = false)
	private Category category;
	
	@Column(name="issue",nullable = false)
	private String IssueDetails;
	
	@Column(name="resolution")
	private String ResolutionDetails;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="creation_DateTime")
	private LocalDateTime creationDateTime;
	
	@Column(name="resolution_DateTime")
	private LocalDateTime resolutionDateTime;

	//CTOR
	public Ticket() {
		super();
	}
	public Ticket(long iD, String phoneNumber, Category category, String issueDetails, String resolutionDetails,
			Status status, LocalDateTime creationDateTime, LocalDateTime resolutionDateTime) {
		super();
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.category = category;
		IssueDetails = issueDetails;
		ResolutionDetails = resolutionDetails;
		this.status = status;
		this.creationDateTime = creationDateTime;
		this.resolutionDateTime = resolutionDateTime;
	}

	

	//GETTER SETTERS
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getIssueDetails() {
		return IssueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		IssueDetails = issueDetails;
	}

	public String getResolutionDetails() {
		return ResolutionDetails;
	}

	public void setResolutionDetails(String resolutionDetails) {
		ResolutionDetails = resolutionDetails;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public LocalDateTime getResolutionDateTime() {
		return resolutionDateTime;
	}

	public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
		this.resolutionDateTime = resolutionDateTime;
	}
	
	
	
}
