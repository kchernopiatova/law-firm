package com.solvd.lawfirm.exception;

public class ServiceTimeException extends RuntimeException {

    public ServiceTimeException(String message) {
        super(message);
    }

    public ServiceTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
