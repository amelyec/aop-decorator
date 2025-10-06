package tz.co.werelay.aop_decorator.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tz.co.werelay.aop_decorator.exception.RateLimitDecoratorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RateLimitDecoratorException.class)
    public ResponseEntity<Object> handleRateLimitExceeded(RateLimitDecoratorException ex) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(new ErrorResponse("RATE_LIMIT_EXCEEDED", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("GENEREC_ERROR", ex.getMessage()));
    }

}
