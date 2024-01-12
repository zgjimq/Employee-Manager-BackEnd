package org.makerminds.javaweb.service;

import java.util.List;


import org.makerminds.javaweb.entity.Employee;

import org.makerminds.javaweb.exceptions.EmployeeNotFoundException;
import org.makerminds.javaweb.repository.DepartmentRepository;
import org.makerminds.javaweb.repository.EmployeeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final DepartmentService departmentService;
	public Employee createOrUpdateEmployee(Employee employee,Long departmentId) {
		employee.setDepartment(departmentService.findById(departmentId));
		return employeeRepository.save(employee);
	}
	
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	/*
	 Department department= departmentRepository.findById(id).orElseThrow( ()->
			 new DepartmentNotFoundException("Department not found!")
			 );
		
		return department;
	 */
	public List<Employee>getEmployeeList(Long departmentId){
		 departmentRepository.findById(departmentId).orElseThrow(() ->
			new EmployeeNotFoundException("Employee Not FOund")
				);
		return departmentRepository.findById(departmentId).get().getEmployeeList();
	}
	
	public ResponseEntity<?> deleteEmpoyeeById(Long departmentId , Long id){
		Employee employee=employeeRepository.findById(id).orElse(null);
		if(employee !=null) {
			if(employee.getDepartment().getId() == departmentId)
			{
					employeeRepository.delete(employee);
					String message= "U have deleted "+id+" id";
					return ResponseEntity.ok().body(message);
			}
			else
			{
				String message="Not able to find this id";
				throw new EmployeeNotFoundException(message);
			}
		}
		else {
			String message="Not able to find this id";
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			throw new EmployeeNotFoundException(message);
		}
		}
	
	public Employee getEmployee(Long departmentid,Long employeeid) {
		Employee employee = findById(employeeid);
		if(employee ==null || employee.getDepartment().getId()!=departmentid ) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return employee;
	}
}
