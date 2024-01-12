package org.makerminds.javaweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.makerminds.javaweb.entity.Task;
import org.makerminds.javaweb.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/tasks") 
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@PostMapping(path = "/{departmentId}/{employeeId}")
	public ResponseEntity<?>addNewTask(@PathVariable Long departmentId, @PathVariable Long employeeId, 
			@Valid @RequestBody Task newTask, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			Map<String, String> errors= new HashMap<>();
			for(FieldError fieldError : bindingResult.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(taskService.createNewTask(departmentId, employeeId,newTask), HttpStatus.CREATED);
	}
	@GetMapping(path = "/{departmentId}/{employeeId}")
	public List<Task>getTaskList(@PathVariable Long departmentId, @PathVariable Long employeeId){
		return taskService.getTaskList(departmentId, employeeId);
	}
	
	@DeleteMapping(path = "/delete/{departmentId}/{employeeId}/{taskId}")
	public ResponseEntity<?>deleteTask(@PathVariable Long departmentId, @PathVariable Long employeeId,@PathVariable Long taskId){
		return taskService.deleteTask(departmentId, employeeId, taskId);
	}
	@GetMapping(path = "/get/{departmentId}/{employeeId}/{taskId}")
	public ResponseEntity<?> getTask(@PathVariable Long departmentId, @PathVariable Long employeeId,@PathVariable Long taskId){
		return new ResponseEntity<>( taskService.getTask(departmentId, employeeId, taskId), HttpStatus.OK);
	}
}
