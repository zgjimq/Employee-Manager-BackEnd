package org.makerminds.javaweb.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentNotFoundExceptionResponse {

	private String departmentNotFoundMessage;
	
	public DepartmentNotFoundExceptionResponse(String message) {
		super();
		this.departmentNotFoundMessage = message;
	}
}
