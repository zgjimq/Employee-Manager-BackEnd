package org.makerminds.javaweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emloyees")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "address",nullable = false)
	private String address;
	@Column(name = "email",nullable = false)
	private String email;
	@Column(name = "phone_Number",nullable = false)
	private String phone_Number;
	 
	public Employee() {
		super()
;	}
	

	public Employee(Long id, String name, String address, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		phone_Number = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phoneNumber) {
		phone_Number = phoneNumber;
	}
	
	 

}
