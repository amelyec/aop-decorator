package tz.co.werelay.aop_decorator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tz.co.werelay.aop_decorator.dtos.TransactionRequest;
import tz.co.werelay.aop_decorator.dtos.TransactionResponse;

@Service
@Primary
public class AuthDecorator implements TransactionService {
    
    private final TransactionService delegate;

    public AuthDecorator(@Qualifier("rateLimitDecorator") TransactionService delegate) {
        this.delegate = delegate;
    }

    @Override
    public TransactionResponse transfer(TransactionRequest request) {
        if(!"VALID_TOKEN".equals("VALID_TOKEN")) {
            throw new SecurityException("Invalid token");
        }
        // Perform authentication logic here
        System.out.println("Authenticating request...");

        // Delegate to the actual service
        return delegate.transfer(request);
    }
    
}
