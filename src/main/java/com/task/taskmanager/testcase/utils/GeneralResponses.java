package com.task.taskmanager.testcase.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GeneralResponses {
	
	public static ResponseEntity<Object> getGeneralResponse(Object data, HttpStatus status) {
		return new ResponseEntity<>(data, status);
	}

}
