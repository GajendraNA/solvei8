package com.gajendra.solvei8.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        String message = ex.getRootCause().getMessage(); // Get database-level error message
//        String fieldName = extractColumnNameFromMessage(message);
//
//        if (fieldName != null) {
//            errors.put(fieldName, fieldName + " already exists");
//        } else {
//            errors.put("error", "Duplicate entry found");
//        }
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
//    }
//
//    private String extractColumnNameFromMessage(String message) {
//        if (message.contains("Key (")) { // PostgreSQL style error message
//            int start = message.indexOf("Key (") + 5;
//            int end = message.indexOf(")=");
//            if (start > 4 && end > start) {
//                return message.substring(start, end).trim();
//            }
//        }
//        return null;
//    }
}
