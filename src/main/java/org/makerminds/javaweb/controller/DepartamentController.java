package org.makerminds.javaweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.makerminds.javaweb.entity.Department;
import org.makerminds.javaweb.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("api/departaments")
@CrossOrigin
@RequiredArgsConstructor
public class DepartamentController {
	
	private final DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<?>createDepartment(@Valid @RequestBody Department department, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<String, String> errors= new HashMap<>();
			for(FieldError fieldError : bindingResult.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors,HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(departmentService.creatDepartment(department));
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?>deleteDepartment(@PathVariable Long id){
		return departmentService.deleteDepartmentById(id);
	} 
	
	@GetMapping(path = "/getAll")
	public Iterable<Department>getDepartments(){
		return departmentService.getDepartments();
	} 
	@GetMapping(path = "getDepartment/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.findById(id);
	}
}
