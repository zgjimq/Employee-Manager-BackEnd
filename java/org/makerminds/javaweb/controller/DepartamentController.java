package org.makerminds.javaweb.controller;

import org.makerminds.javaweb.entity.Department;
import org.makerminds.javaweb.service.DepartmentService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("api/departaments")
@CrossOrigin
@RequiredArgsConstructor
public class DepartamentController {
	
	private final DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department>createDepartment(@RequestBody Department department){
		return ResponseEntity.ok(departmentService.creatDepartment(department));
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?>deleteDepartment(@PathVariable Long id){
		return departmentService.deleteDepartmentById(id);
	}
	
	@GetMapping(path = "/getAll")
	public Iterable<Department>getAll(){
		return departmentService.getDepartment();
	}
}
