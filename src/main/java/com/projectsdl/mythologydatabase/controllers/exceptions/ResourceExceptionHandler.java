package com.projectsdl.mythologydatabase.controllers.exceptions;

import com.projectsdl.mythologydatabase.services.exceptions.DatabaseException;
import com.projectsdl.mythologydatabase.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> objNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String msg = "object not found";
        StandardError err = new StandardError(Instant.now(), status.value(), msg,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String msg = "database error";
        StandardError err = new StandardError(Instant.now(),status.value(),msg,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
