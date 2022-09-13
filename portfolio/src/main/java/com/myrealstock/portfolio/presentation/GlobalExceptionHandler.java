package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.DuplicatedPortfolioNameException;
import com.myrealstock.portfolio.domain.PortfolioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedPortfolioNameException.class)
    public ResponseEntity handlerDuplicatedPortfolioNameException(DuplicatedPortfolioNameException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_EXTENDED);
    }

    @ExceptionHandler(PortfolioNotFoundException.class)
    public ResponseEntity handlerPortfolioNotFoundException(PortfolioNotFoundException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_EXTENDED);
    }



}
