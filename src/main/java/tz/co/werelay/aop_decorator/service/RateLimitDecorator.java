package tz.co.werelay.aop_decorator.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tz.co.werelay.aop_decorator.dtos.TransactionRequest;
import tz.co.werelay.aop_decorator.dtos.TransactionResponse;
import tz.co.werelay.aop_decorator.exception.RateLimitDecoratorException;

@Service("rateLimitDecorator")
public class RateLimitDecorator implements TransactionService {

    private final TransactionService delegate;
    private final Map<String, Integer> requestCount = new HashMap<>();

    public RateLimitDecorator(@Qualifier("coreTransactionService") TransactionService delegate) {
        this.delegate = delegate;
    }

    @Override
    public TransactionResponse transfer(TransactionRequest request) {
        int count = requestCount.getOrDefault(request.getFromAccount(), 0);
        if (count >= 3) {
            throw new RateLimitDecoratorException("Rate limit exceeded");
        }
        requestCount.put(request.getFromAccount(), count + 1);
        // Perform authentication logic here
        System.out.println("Rate limit check ..." + count);
        return delegate.transfer(request);
    }

}
