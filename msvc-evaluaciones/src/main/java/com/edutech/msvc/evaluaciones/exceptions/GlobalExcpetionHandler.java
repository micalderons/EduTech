package com.edutech.msvc.evaluaciones.exceptions;

import com.edutech.msvc.evaluaciones.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExcpetionHandler {

    private ErrorDTO createErrorDTO(int status, Date date, Map<String, String> errorMap){
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(status);
        errorDTO.setDate(date);
        errorDTO.setErrors(errorMap);

        return errorDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                this.createErrorDTO(HttpStatus.BAD_REQUEST.value(), new Date(), errorMap)
        );


    }

    @ExceptionHandler(EvaluacionException.class)
    public ResponseEntity<ErrorDTO> handleEvaluacionException(EvaluacionException exception){

        if (exception.getMessage().contains("No se encuentra en la base de datos")){
            Map<String, String> errorMap = Collections.singletonMap("Evaluacion no encontrada", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(this.createErrorDTO(HttpStatus.NOT_FOUND.value(), new Date(), errorMap));
        }else{
            Map<String, String> errorMap = Collections.singletonMap("Evaluacion existente", exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(this.createErrorDTO(HttpStatus.CONFLICT.value(), new Date(), errorMap));
        }
    }




}
