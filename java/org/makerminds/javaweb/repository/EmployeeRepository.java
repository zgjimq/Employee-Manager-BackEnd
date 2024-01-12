package org.makerminds.javaweb.repository;

import java.util.Optional;


import org.makerminds.javaweb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Optional<Employee> findById(Long id);
}
