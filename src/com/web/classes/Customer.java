package com.web.classes;

public class Customer {

	private String firstName, lastName, email, company, ipAddress;
	private int id;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Customer(String firstName, String lastName, String email, String company, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.id = id;
	}
	
	public Customer(String firstName, String lastName, String email, String company, int id, String ipAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.id = id;
		this.ipAddress = ipAddress;
	}
	
	public Customer(String firstName, String lastName, String email, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
	}
	
	public Customer(String firstName, String lastName, String email, String company, String ipAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.ipAddress = ipAddress;
	}
}
