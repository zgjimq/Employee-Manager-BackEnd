package org.makerminds.javaweb.controller;

import java.util.List;

import org.makerminds.javaweb.entity.Employee;
import org.makerminds.javaweb.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}

	@PostMapping(path = "/addEmployee")
	public ResponseEntity<?> createEmployees(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createOrUpdateEmployee(employee));
	}
	@GetMapping(path = "/get/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	@GetMapping(path = "getAll")
	public List<Employee>getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?>deleteEmployeeById(@PathVariable Long id){
		return employeeService.deleteEmpoyeeById(id);
	}
	
}
