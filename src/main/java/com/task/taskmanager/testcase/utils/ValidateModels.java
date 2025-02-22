package com.task.taskmanager.testcase.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.task.taskmanager.domain.dto.Error;
import com.task.taskmanager.domain.dto.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;;

public final class ValidateModels {

	public static <T> List<Error> validateModel(T object) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(object);
		List<Error> errores = new ArrayList<>();
		for (ConstraintViolation<T> violation : violations) {
			String errorAnotation = violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
			String title = "";
			String errorCode = "";
			switch (errorAnotation) {
			case "Size":
				title = CommonConstants.BACKEND_SIZE_ERROR_TITLE;
				errorCode = CommonConstants.BACKEND_SIZE_ERROR_CODE;
				break;
			case "NotNull":
				title = CommonConstants.BACKEND_NULL_ERROR_TITLE;
				errorCode = CommonConstants.BACKEND_NULL_ERROR_CODE;
				break;
			case "NotBlank":
				title = CommonConstants.BACKEND_BLANK_ERROR_TITLE;
				errorCode = CommonConstants.BACKEND_BLANK_ERROR_CODE;
				break;
			case "Pattern":
				title = CommonConstants.BACKEND_PATTERN_CODE;
				errorCode = CommonConstants.BACKEND_PATTERN_TITLE;
				break;
			default:
				break;
			}
			errores.add(new Error(errorCode, title, violation.getMessage()));
		}
		return errores;
	}
	
	public static <T> ResponseEntity<Object> startValidation(T object) {
		List<Error> errores = null;
		errores = validateModel(object);

		return GeneralResponses.getGeneralResponse(new ErrorResponse(CommonConstants.HTTP_CODE_BAD_REQUEST, errores), HttpStatus.BAD_REQUEST);
	}

}
