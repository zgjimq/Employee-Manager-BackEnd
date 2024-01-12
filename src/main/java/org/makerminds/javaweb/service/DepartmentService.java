package org.makerminds.javaweb.service;



import java.util.List;

import org.makerminds.javaweb.entity.Department;
import org.makerminds.javaweb.exceptions.DepartmentNotFoundException;
import org.makerminds.javaweb.repository.DepartmentRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DepartmentService { 
	
	
	private final DepartmentRepository departmentRepository;
	
	
	public Department creatDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public ResponseEntity<?> deleteDepartmentById(Long id){
		Department department=departmentRepository.findById(id).orElseThrow( () -> new DepartmentNotFoundException("Department Not Found"));
		
			departmentRepository.delete(department);
			String message= "U have deleted "+id+" id";
			return ResponseEntity.ok().body(message);
		
		
	}
	public List<Department> getDepartments(){
		return departmentRepository.findAll();
	}
	public Department findById(Long id) {
		
		Department department= departmentRepository.findById(id).orElseThrow( ()->
			 new DepartmentNotFoundException("Department not found!")
			 );
		
		return department;
	}

}
