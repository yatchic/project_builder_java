package org.example.domain.exceptions;

public class InvalidDateException extends InvalidUserInputException {
    public InvalidDateException(String message) {
        super(message);
    }
}
