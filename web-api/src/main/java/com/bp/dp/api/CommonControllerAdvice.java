package com.bp.dp.api;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.bp.dp.api")
public class CommonControllerAdvice {
    private static final String ERROR_TEMPLATE = "For field [%s] value [%s] is invalid because %s";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> validationViolatedResponse(MethodArgumentNotValidException validationException) {
        return validationException.getBindingResult().getAllErrors().stream()
                .map(this::getErrorMessage)
                .toList();
    }

    private String getErrorMessage(ObjectError error) {
        if (error instanceof FieldError fieldError) {
            return String.format(ERROR_TEMPLATE, fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
        }
        return error.getDefaultMessage();
    }
}