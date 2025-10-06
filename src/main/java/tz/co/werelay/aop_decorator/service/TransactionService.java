package tz.co.werelay.aop_decorator.service;

import tz.co.werelay.aop_decorator.dtos.TransactionRequest;
import tz.co.werelay.aop_decorator.dtos.TransactionResponse;

public interface TransactionService {
    
    TransactionResponse transfer(TransactionRequest request);
}
