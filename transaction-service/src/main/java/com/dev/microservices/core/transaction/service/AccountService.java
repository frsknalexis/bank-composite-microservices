package com.dev.microservices.core.transaction.service;

import com.dev.microservices.core.transaction.entity.AccountHolder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Flux<AccountHolder> getAllAccounts();

    Mono<AccountHolder> getAccountById(Long accountId);

    Mono<AccountHolder> createAccount(AccountHolder account);

    Mono<AccountHolder> updateAccount(AccountHolder account);

    Mono<Void> deleteAccount(Long accountNumber);
}