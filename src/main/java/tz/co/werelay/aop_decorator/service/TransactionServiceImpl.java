package tz.co.werelay.aop_decorator.service;

import org.springframework.stereotype.Service;

import tz.co.werelay.aop_decorator.dtos.TransactionRequest;
import tz.co.werelay.aop_decorator.dtos.TransactionResponse;

@Service("coreTransactionService")
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionResponse transfer(TransactionRequest request) {
        // Simulate a transfer operation
        TransactionResponse response = new TransactionResponse();
        response.setStatus("SUCCESS");
        response.setTransactionId("TXN123456");
        return response;
    }

}
