package com.task.taskmanager.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.service.spec.UserTaskService;
import com.task.taskmanager.testcase.utils.ValidateModels;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserTaskController {
	
	@Autowired
	UserTaskService userTaskService;
	
	@GetMapping("/user")
	public ResponseEntity<?> getUser() {
		try {
			List<UserTask> users = userTaskService.getAllUser();
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserTask user, BindingResult bindingResult) {
		System.out.println(user.getName());
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(user);
		}
		UserTask newUser = userTaskService.createUser(user);
		if(newUser != null) {
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserTask user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(user);
		}
		UserTask updatedUser = userTaskService.updateUser(user);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		UserTask user = userTaskService.getUserById(id);
		if(user != null) {
			userTaskService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
