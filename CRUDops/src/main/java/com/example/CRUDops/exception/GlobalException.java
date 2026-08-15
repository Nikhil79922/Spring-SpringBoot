package com.example.CRUDops.exception;

import com.example.CRUDops.dto.DuplicateException;
import com.example.CRUDops.dto.ExceptionValidationDTO;
import com.example.CRUDops.dto.ValidationExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionValidationDTO> handleResourceNotFoundException(ResourceNotFoundException e , HttpServletRequest request ) {
        return new ResponseEntity<>(new ExceptionValidationDTO(false , e.getMessage() , LocalDateTime.now() , HttpStatus.NOT_FOUND.value() , request.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e , HttpServletRequest request ) {

        Map<String, String> errors = new HashMap<>();

      e.getBindingResult().getFieldErrors().forEach(
              err -> errors.put(err.getField(), err.getDefaultMessage())
      );

        return new ResponseEntity<>(new ValidationExceptionDto(false , HttpStatus.BAD_REQUEST.getReasonPhrase() , LocalDateTime.now() , HttpStatus.BAD_REQUEST.value() , request.getRequestURI() , errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionValidationDTO> handleDuplicateException(DuplicateException e , HttpServletRequest request ) {
        return new ResponseEntity<>(new ExceptionValidationDTO(false , e.getMessage() , LocalDateTime.now() , HttpStatus.CONFLICT.value() , request.getRequestURI()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionValidationDTO> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e , HttpServletRequest request ) {
        return new ResponseEntity<>(new ExceptionValidationDTO(false , e.getMessage() , LocalDateTime.now() , HttpStatus.BAD_REQUEST.value() , request.getRequestURI()), HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionValidationDTO> handleException(RuntimeException e , HttpServletRequest request ) {
        System.out.println(e.getClass());
        return  new ResponseEntity<>(new ExceptionValidationDTO(false , e.getMessage() , LocalDateTime.now() ,  HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI()),  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Last Fallback , if anything breaks..
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionValidationDTO> handleGenericException(Exception e , HttpServletRequest request) {
        return  new ResponseEntity<>(new ExceptionValidationDTO(false , "Something went wrong. Please try again later" , LocalDateTime.now() ,  HttpStatus.INTERNAL_SERVER_ERROR.value() , request.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
