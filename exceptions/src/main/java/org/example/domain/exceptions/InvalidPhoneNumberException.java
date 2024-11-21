package org.example.domain.exceptions;

public class InvalidPhoneNumberException extends InvalidUserInputException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
