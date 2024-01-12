package org.makerminds.javaweb.repository;

import java.util.Optional;

import org.makerminds.javaweb.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartmentRepository extends JpaRepository<Department, Long>{
	public Optional<Department> findById(Long id);
}
