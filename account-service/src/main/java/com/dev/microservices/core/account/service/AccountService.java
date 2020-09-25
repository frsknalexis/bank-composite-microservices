package com.dev.microservices.core.account.service;

import com.dev.microservices.core.account.model.AccountHolder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Flux<AccountHolder> getAllAccounts();

    Mono<AccountHolder> getAccountById(Long accountNumber);

    Mono<AccountHolder> createAccount(AccountHolder accountHolder);

    Mono<AccountHolder> updateAccount(AccountHolder accountHolder);

    Mono<Void> deleteAccount(Long accountNumber);
}