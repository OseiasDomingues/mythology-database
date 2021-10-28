package com.projectsdl.mythologydatabase.services.exceptions;

public class ObjectNotFound extends RuntimeException{

    public ObjectNotFound(Long id) {
        super("ID " + id + " not found");
    }
}
