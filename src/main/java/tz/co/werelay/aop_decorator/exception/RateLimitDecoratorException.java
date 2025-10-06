package tz.co.werelay.aop_decorator.exception;

public class RateLimitDecoratorException extends RuntimeException {
    public RateLimitDecoratorException(String message) {
        super(message);
    }
    
}
