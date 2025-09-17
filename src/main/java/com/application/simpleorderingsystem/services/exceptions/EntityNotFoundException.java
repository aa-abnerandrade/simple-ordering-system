package com.application.simpleorderingsystem.services.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private final static long serialVersionUID = 1L;

    public EntityNotFoundException(String msg) {
        super(msg);

    }
}
