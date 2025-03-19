package com.example.Backend._3.Irmaos.handler;

import com.example.Backend._3.Irmaos.entity.ErrorPersonalizado;
import com.example.Backend._3.Irmaos.exception.FailPasswordException;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // Define o status HTTP 404
    @ExceptionHandler(NotFoundException.class)
    public ErrorPersonalizado handler(NotFoundException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(FailPasswordException.class)
    public ErrorPersonalizado handler(FailPasswordException ex) {return new ErrorPersonalizado(ex.getMessage());}
}