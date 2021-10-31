package com.solvd.lawfirm.exception;

public class EmptySetException extends RuntimeException {

    public EmptySetException() {
    }

    public EmptySetException(String message) {
        super(message);
    }
}
