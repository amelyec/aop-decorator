package tz.co.werelay.aop_decorator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tz.co.werelay.aop_decorator.dtos.TransactionRequest;
import tz.co.werelay.aop_decorator.dtos.TransactionResponse;
import tz.co.werelay.aop_decorator.service.TransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public TransactionResponse transfer(@RequestBody TransactionRequest request) {

        return transactionService.transfer(request);
    }

}
