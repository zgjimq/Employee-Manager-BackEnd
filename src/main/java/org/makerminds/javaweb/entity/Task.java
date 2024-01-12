package org.makerminds.javaweb.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Description is required.")
	//@Size(min = 20,max = 250)
	private String description;
	@NotBlank(message = "Acceptance Criteria is required.")
	//@Size(min = 20,max = 250)
	private String acceptanceCriteria; 
	//@NotBlank(message =  "status is required")
	private String status;
	//@NotBlank(message = "Priority is required.")
	@Positive(message = "Priority needs to be an positive number")
	@Min(value = 1, message = "minimal value for priority is 1")
	@Max(value = 3,message = "maximum value for priority is 3")
	private int priority; 
	
	@ManyToOne (fetch =  FetchType.EAGER)
	@JoinColumn(name = "employeeId", updatable = false, nullable = false)
	private Employee employee;
	 
}
