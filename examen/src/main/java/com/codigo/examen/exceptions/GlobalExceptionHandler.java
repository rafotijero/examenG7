package com.codigo.examen.exceptions;

import com.codigo.examen.util.Constantes;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<String> handleInvalidStatusException(InvalidStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if (ex.getMessage().contains("id_number")) {
            return new ResponseEntity<>(Constantes.VALIDATION_ID_NUMBER, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(Constantes.VALIDATION_ID_NUMBER, HttpStatus.BAD_REQUEST);
    }

}
