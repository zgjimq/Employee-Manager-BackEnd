package org.makerminds.javaweb.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskNotFoundExceptionResponse {
	private String taskNotFoundMessage;

	public TaskNotFoundExceptionResponse(String taskNotFoundMessage) {
		super();
		this.taskNotFoundMessage = taskNotFoundMessage;
	}
	
	
}
