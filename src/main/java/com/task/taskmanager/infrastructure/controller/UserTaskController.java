package com.task.taskmanager.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.service.spec.UserTaskService;

@RestController
@RequestMapping("/api")
public class UserTaskController {
	
	@Autowired
	UserTaskService userTaskService;
	
	@GetMapping("/user")
	public ResponseEntity<?> getUsuarios() {
		try {
			List<UserTask> usuarios = userTaskService.getAllUser();
			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
