package com.solvd.lawfirm.exception;

public class EmptyArrayException extends RuntimeException {

    public EmptyArrayException(String message) {
        super(message);
    }

    public EmptyArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
