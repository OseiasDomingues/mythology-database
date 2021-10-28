package com.projectsdl.mythologydatabase.controllers.exceptions;

import com.projectsdl.mythologydatabase.services.exceptions.ObjectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objNotFound(ObjectNotFound e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String msg = "Object not found";
        StandardError err = new StandardError(Instant.now(), status.value(), msg,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
