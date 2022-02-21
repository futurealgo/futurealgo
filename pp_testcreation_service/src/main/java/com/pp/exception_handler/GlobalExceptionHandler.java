package com.pp.exception_handler;

import com.pp.api.test_category.exceptions.BadRequestException;
import com.pp.models.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( value = {BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(BadRequestException exception){
        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).date(LocalDateTime.now()).description(exception.getLocalizedMessage()).build();
    }
}
