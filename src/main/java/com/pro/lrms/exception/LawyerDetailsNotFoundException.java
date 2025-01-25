package com.pro.lrms.exception;

/**
 * Custom exception class for handling scenarios where lawyer details are not found or database is empty.
 * Extends the RuntimeException class to allow unchecked exceptions.
 */
public class LawyerDetailsNotFoundException extends RuntimeException {

    /**
     * Serial version UID for ensuring the class is compatible during the serialization process.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to create a new instance of LawyerDetailsNotFoundException.
     * 
     * @param message The detailed error message to be displayed when the exception is thrown and cause of the exception.
     */
    public LawyerDetailsNotFoundException(String message) {
        super(message);
    }
}
