package com.nomi.exception;


public class RemoteServiceAccessException extends RuntimeException {

    public RemoteServiceAccessException(String message) {
        super(message);
    }

    public RemoteServiceAccessException() {
    }
}
