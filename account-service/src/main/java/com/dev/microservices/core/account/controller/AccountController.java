package com.dev.microservices.core.account.controller;

import com.dev.microservices.core.account.model.AccountHolder;
import com.dev.microservices.core.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/account-service")
public class AccountController {

    private final AccountService accountService;

    public AccountController(@Autowired @Qualifier("accountService") AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts", produces = { APPLICATION_JSON_VALUE })
    public Flux<AccountHolder> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/account", produces = { APPLICATION_JSON_VALUE })
    public Mono<AccountHolder> getAccount(@RequestParam(value = "accountNumber") Long accountNumber) {
        return accountService.getAccountById(accountNumber);
    }

    @PostMapping(value = "/account", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<AccountHolder> createAccount(@RequestBody Mono<AccountHolder> account) {
        return account
                .map(accountHolder -> {
                    accountHolder.setAccountStartDate(LocalDateTime.now());
                    return accountHolder;
                })
                .flatMap(accountService::createAccount);
    }

    @PutMapping(value = "/account", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<AccountHolder> updateAccount(@RequestBody Mono<AccountHolder> account) {
        return account.flatMap(accountService::updateAccount);
    }

    @DeleteMapping(value = "/account")
    public Mono<Void> deleteAccount(@RequestParam(value = "accountNumber") Long accountNumber) {
        return accountService.deleteAccount(accountNumber);
    }

    @GetMapping(value = "/account/transactions", produces = { APPLICATION_JSON_VALUE })
    public Mono<AccountHolder> getTransactionHistoryForAccount(@RequestParam(value = "accountNumber") Long accountNumber) {
        return accountService.getAccountById(accountNumber);
    }
}