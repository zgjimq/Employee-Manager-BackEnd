package org.makerminds.javaweb.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundExceptionResponse {
	private String employeeNotFoundMessageString;

	public EmployeeNotFoundExceptionResponse(String employeeNotFoundMessageString) {
		super();
		this.employeeNotFoundMessageString = employeeNotFoundMessageString;
	}
	
	
}
