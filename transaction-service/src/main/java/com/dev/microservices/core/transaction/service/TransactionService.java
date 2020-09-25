package com.dev.microservices.core.transaction.service;

import com.dev.microservices.core.transaction.entity.Transaction;
import com.dev.microservices.core.transaction.model.response.TransactionDetailResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionDetailResponse> deposit(Transaction transaction);

    Mono<TransactionDetailResponse> transfer(Transaction transaction);

    Mono<TransactionDetailResponse> withdraw(Transaction transaction);

    Flux<Transaction> getTransactions(Long accountNumber);
}
