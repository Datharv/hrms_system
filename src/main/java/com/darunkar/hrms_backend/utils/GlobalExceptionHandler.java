package com.darunkar.hrms_backend.utils;

import com.darunkar.hrms_backend.dto.ApiResponse;
import com.darunkar.hrms_backend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(
				new ApiResponse<>(false, ex.getMessage(), null),
				HttpStatus.NOT_FOUND
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<String>> handleValidationError(MethodArgumentNotValidException ex) {
		String errorMsg = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(", "));

		return new ResponseEntity<>(
				new ApiResponse<>(false, errorMsg, null),
				HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleGenericError(Exception ex) {
		return new ResponseEntity<>(
				new ApiResponse<>(false, "Something went wrong: " + ex.getMessage(), null),
				HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
}
