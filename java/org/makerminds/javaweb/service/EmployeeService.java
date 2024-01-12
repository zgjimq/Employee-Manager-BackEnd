package org.makerminds.javaweb.service;

import java.util.List;


import org.makerminds.javaweb.entity.Employee;
import org.makerminds.javaweb.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public Employee createOrUpdateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	public List<Employee>getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public ResponseEntity<?> deleteEmpoyeeById(Long id){
		Employee employee=employeeRepository.findById(id).orElse(null);
		if(employee !=null) {
			employeeRepository.deleteById(id);
			String message= "U have deleted "+id+" id";
			return ResponseEntity.ok().body(message);
		}
		else {
			String message="Not able to find this id";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
		}
}
