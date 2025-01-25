package com.pro.lrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Global exception handler to handle application-wide exceptions.
 * Centralizes exception handling and returns appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles general exceptions (unhandled or runtime errors).
     * 
     * @param ex The exception object.
     * @return ResponseEntity with a generic error message and HTTP status 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Handles exceptions when lawyer details are not found.
     * 
     * @param ex The exception object (specific to LawyerDetailsNotFoundException).
     * @return ResponseEntity with an error message and HTTP status 404 (Not Found).
     */
    @ExceptionHandler(LawyerDetailsNotFoundException.class)
    public ResponseEntity<String> handleUserDetailsNotFoundException(LawyerDetailsNotFoundException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles invalid arguments passed to the application (e.g., validation errors).
     * 
     * @param ex The exception object (specific to IllegalArgumentException).
     * @return ResponseEntity with an error message and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
