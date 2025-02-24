package com.task.taskmanager.domain.dto;

import java.util.List;

public class ErrorResponse {

	private int statusCode;
	private List<Error> errors;
	
	public ErrorResponse(int statusCode, List<Error> errors) {
		super();
		this.statusCode = statusCode;
		this.errors = errors;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
}
