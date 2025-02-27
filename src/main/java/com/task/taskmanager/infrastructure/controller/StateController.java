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
import com.task.taskmanager.infrastructure.service.spec.StateService;
import com.task.taskmanager.testcase.utils.ValidateModels;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "http://34.45.249.205:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class StateController {

	@Autowired
	StateService stateService;
	
	@GetMapping("/state")
	public ResponseEntity<?> getState() {
		try {
			List<State> states = stateService.getAllState();
			if (states.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(states, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/state")
	public ResponseEntity<?> createState(@Valid @RequestBody State state, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(state);
		}
		State newState = stateService.createState(state);
		if(newState != null) {
			return new ResponseEntity<>(newState, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PutMapping("/state/{id}")
	public ResponseEntity<?> updateState(@Valid @RequestBody State state, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ValidateModels.startValidation(state);
		}
		State updatedState = stateService.updateState(state);
		if (updatedState != null) {
			return new ResponseEntity<>(updatedState, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/state/{id}")
	public ResponseEntity<?> deleteState(@PathVariable("id") Long id) {
		State state = stateService.getStateById(id);
		if(state != null) {
			stateService.deleteState(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
