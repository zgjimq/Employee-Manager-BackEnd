package org.makerminds.javaweb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emloyees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotBlank(message = "Employee name is required.")
	@Column(name = "name", nullable = false)
	private String name;
	@NotBlank(message = "Employee address is required.") 
	@Column(name = "address",nullable = false)
	private String address;
	@NotBlank(message = "Email is required.")
	 
	@Email(message = "Invalid email format")
	@Column(name = "email",nullable = false)
	private String email;
	@NotBlank(message = "Phone number is required.")
	@Size(min =12, max = 12, message = "Invalid phone number.")
	@Column(name = "phoneNumber",nullable = false)	
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId", nullable = false, updatable = false)
	private Department department;
	 
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonIgnore
	private List<Task> taskList;
}
