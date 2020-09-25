package com.dev.microservices.core.transaction.controller;

import com.dev.microservices.core.transaction.entity.AccountHolder;
import com.dev.microservices.core.transaction.entity.Transaction;
import com.dev.microservices.core.transaction.model.response.TransactionDetailResponse;
import com.dev.microservices.core.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(@Autowired @Qualifier("transactionService") TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/deposit", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> deposit(@RequestBody Mono<Transaction> transaction) {
        return transaction.flatMap(transactionService::deposit);
    }

    @PostMapping(value = "/withdraw", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> withdraw(@RequestBody Mono<Transaction> transaction) {
        return transaction.flatMap(transactionService::withdraw);
    }

    @PostMapping(value = "/transfer", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> transfer(@RequestBody Mono<Transaction> transaction) {
        return transaction.flatMap(transactionService::transfer);
    }

    @PostMapping(value = "/transactions", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Flux<Transaction> getTransactions(@RequestBody Mono<AccountHolder> account) {
        return account.map(AccountHolder::getAccountNumber)
                .flatMapMany(transactionService::getTransactions);
    }
}