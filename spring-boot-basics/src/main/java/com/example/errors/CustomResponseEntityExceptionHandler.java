package com.example.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<ProblemDetail> handleUserNotFoundException(UserNotFound ex) {
        ProblemDetail details = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        details.setProperty("path", ServletUriComponentsBuilder.fromCurrentRequest().build().toUri());
        details.setProperty("timestamp", LocalDateTime.now());
        return ResponseEntity.of(details).build();
    }
}
