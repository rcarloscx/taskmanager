package com.task.taskmanager.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.taskmanager.domain.entity.State;
import com.task.taskmanager.domain.entity.Task;
import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.service.spec.StateService;
import com.task.taskmanager.infrastructure.service.spec.TaskService;
import com.task.taskmanager.infrastructure.service.spec.UserTaskService;
import com.task.taskmanager.testcase.utils.ValidateModels;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserTaskService userTaskService;
	
	@Autowired
	StateService stateService;
	
	@GetMapping("/task")
	public ResponseEntity<?> getTask() {
		try {
			System.out.println("se obtienente las tareas");
			List<Task> tasks = taskService.getAllTask();
			if (tasks.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/task")
	public ResponseEntity<?> createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(task);
		}
		Task newTask = new Task();
		State itemState = stateService.getStateById(task.getStatus());
		task.setState(itemState);
		if (itemState==null) {
			return new ResponseEntity<>("Estado no encontrado", HttpStatus.NOT_FOUND);
		}
		newTask = taskService.createTask(task);
		if(newTask != null) {
			return new ResponseEntity<>(newTask, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PutMapping("/task/{id}")
	public ResponseEntity<?> updateTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(task);
		}
		Task updatedTask = taskService.updateTask(task);
		if (updatedTask != null) {
			return new ResponseEntity<>(updatedTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
		Task task = taskService.getTaskById(id);
		if(task != null) {
			taskService.deleteTask(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
