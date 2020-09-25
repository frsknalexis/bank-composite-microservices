package com.dev.microservices.core.transaction.service.impl;

import com.dev.microservices.core.transaction.entity.AccountHolder;
import com.dev.microservices.core.transaction.repository.AccountRepository;
import com.dev.microservices.core.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(@Autowired @Qualifier("accountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Flux<AccountHolder> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<AccountHolder> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Transactional
    @Override
    public Mono<AccountHolder> createAccount(AccountHolder account) {
        return Mono.just(account)
                .map(accountHolder -> {
                    accountHolder.setAccountStartDate(LocalDateTime.now());
                    return accountHolder;
                })
                .flatMap(accountRepository::save);
    }

    @Transactional
    @Override
    public Mono<AccountHolder> updateAccount(AccountHolder account) {
        return accountRepository.findById(account.getAccountNumber())
                .map(accountHolder -> {
                    if (account.getAccountFirstName() != null) {
                        accountHolder.setAccountFirstName(account.getAccountFirstName());
                    }
                    if (account.getAccountLastName() != null) {
                        accountHolder.setAccountLastName(account.getAccountLastName());
                    }

                    if (account.getAddress() != null) {
                        accountHolder.setAddress(account.getAddress());
                    }

                    if (account.getMobileNumber() != null) {
                        accountHolder.setMobileNumber(account.getMobileNumber());
                    }
                    return accountHolder;
                })
                .flatMap(accountRepository::save);
    }

    @Transactional
    @Override
    public Mono<Void> deleteAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .flatMap(accountRepository::delete);
    }
}