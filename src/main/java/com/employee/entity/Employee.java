package com.employee.entity;

import java.time.LocalDate;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;	
	private long phoneNumber;
	private LocalDate dateOfBirth;
	private LocalDate weddingDate;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String address, String emailId, long phoneNumber,
			LocalDate dateOfBirth, LocalDate weddingDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.weddingDate = weddingDate;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(LocalDate weddingDate) {
		this.weddingDate = weddingDate;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", weddingDate="
				+ weddingDate + "]";
	}

	public Employee(String firstName, long phoneNumber) {
		super();
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}

	public Employee(String firstName, String emailId) {
		super();
		this.firstName = firstName;
		this.emailId = emailId;
	}
	
	
}
