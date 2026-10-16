package com.duoc.RopaStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGeneral {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarError(Exception excepcion) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error: " + excepcion.getMessage());
    }
}