package com.frknuzn.basitstok.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
@Slf4j
public class IMExceptionHandler extends ResponseEntityExceptionHandler {
    //Rest controller a bağlan ve bir hata ile karşılaşırsan bu metodu çalıştır.
        @ExceptionHandler(Exception.class)
        public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
            log.error("Controller Advice -> ExceptionHandler ->", ex,request);
            ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage());
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
        }
}
