package com.exam_management_system.ems.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidations(MethodArgumentNotValidException ex){
		String message = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(e -> e.getField() + ": " + e.getDefaultMessage())
	            .collect(Collectors.joining(", "));

	    return ResponseEntity.badRequest()
	            .body(new ErrorResponse(
	                    400,
	                    message,
	                    LocalDateTime.now()
	            ));
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex){
		ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}



/*
 * Interview point: try-catch handles an exception locally. @RestControllerAdvice provides 
 * centralized exception handling across controller methods, and 
 * Spring MVC resolves the exception to the appropriate HTTP response.
 */
