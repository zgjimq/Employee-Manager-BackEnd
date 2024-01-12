package org.makerminds.javaweb.repository;

import org.makerminds.javaweb.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface TaskRepository  extends JpaRepository<Task, Long>{

}
