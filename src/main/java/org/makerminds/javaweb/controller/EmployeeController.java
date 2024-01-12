package org.makerminds.javaweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.makerminds.javaweb.entity.Employee;
import org.makerminds.javaweb.service.EmployeeService;
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
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;


	@PostMapping(path = "/{id}")
	public ResponseEntity<?> createEmployees(@Valid @RequestBody Employee employee, BindingResult bindingResult,@PathVariable Long id){
		if(bindingResult.hasErrors()) {
			Map<String, String>errors=new HashMap<>();
			for(FieldError fieldError :  bindingResult.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(employeeService.createOrUpdateEmployee(employee,id));
	}
	@GetMapping(path = "/get/{depId}/{empId}") 
	public Employee getEmployeeById(@PathVariable Long depId,@PathVariable Long empId) {
		return employeeService.getEmployee(depId, empId);
	}
	@GetMapping(path = "/getAll/{id}")
	public List<Employee>getAllEmployees(@PathVariable Long id){
		return employeeService.getEmployeeList(id);
	} //eronita
	@DeleteMapping(path = "/delete/{depid}/{id}")
	public ResponseEntity<?>deleteEmployeeById(@PathVariable Long depid,@PathVariable Long id){
		return employeeService.deleteEmpoyeeById(depid,id);
	}
	 
}
