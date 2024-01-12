package org.makerminds.javaweb.service;

import java.util.List;

import org.makerminds.javaweb.entity.Employee;
import org.makerminds.javaweb.entity.Task;
import org.makerminds.javaweb.exceptions.TaskNotFoundException;

import org.makerminds.javaweb.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepository;
	private final EmployeeService employeeService;
	
	public Task createNewTask(Long departmentId,Long employeeId,Task newTask) {
		 	Employee employee= employeeService.getEmployee(departmentId, employeeId);
		 	newTask.setEmployee(employee);
		 	if(newTask.getId()==null) 
		 	newTask.setStatus("Input Queue"); 
		 	return taskRepository.save(newTask);
	}
	
	public List<Task> getTaskList(Long departmentID,Long employeeID){
		 return employeeService.getEmployee(departmentID, employeeID).getTaskList();
	}
	
	public ResponseEntity<?> deleteTask(Long departmentId,  Long employeeId ,Long taskId){
		/*Employee employee = employeeService.getEmployee(departmentId, employeeId);
		// a ekzisoton puntori
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
		//kontrollu a eshte a atij puntori taska
		if(task.getEmployee().getId()== employeeId) {
			taskRepository.delete(task);
			return ResponseEntity.ok().body("Task with id:"+ taskId+" has been deleted.");
		}
		throw new TaskNotFoundException("Task not found.");*/
		//e marrum direkt prej metodes ska nevoj per kete nalt
		taskRepository.delete(getTask(departmentId, employeeId, taskId));
		return ResponseEntity.ok().body("Task with id:"+ taskId+" has been deleted.");
	}
	
	public Task getTask(Long departmentId,  Long employeeId ,Long taskId) {
		employeeService.getEmployee(departmentId, employeeId);
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
		
		if(task.getEmployee().getId() == employeeId) {
			return task;
		}
		throw new TaskNotFoundException("Task not found");
	}
	
}
