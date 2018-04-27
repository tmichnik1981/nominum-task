package com.nomi.exception;

public class ServiceUnAvailableException extends RuntimeException {

    public ServiceUnAvailableException(String message) {
        super(message);
    }

    public ServiceUnAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
