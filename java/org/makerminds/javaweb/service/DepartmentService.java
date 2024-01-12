package org.makerminds.javaweb.service;



import java.util.List;

import org.makerminds.javaweb.entity.Department;
import org.makerminds.javaweb.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service


public class DepartmentService { 
	
	
	private final DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository=departmentRepository;
	}
	
	
	public Department creatDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public ResponseEntity<?> deleteDepartmentById(Long id){
		Department department=departmentRepository.findById(id).orElse(null);
		if(department !=null) {
			departmentRepository.deleteById(id);
			String message= "U have deleted "+id+" id";
			return ResponseEntity.ok().body(message);
		}
		else {
			String message="Not able to find this id";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	public List<Department> getDepartment(){
		return departmentRepository.findAll();
	}

}
