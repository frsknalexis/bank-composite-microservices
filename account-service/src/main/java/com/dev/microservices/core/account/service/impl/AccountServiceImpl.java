package com.dev.microservices.core.account.service.impl;

import com.dev.microservices.core.account.model.AccountHolder;
import com.dev.microservices.core.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final WebClient.Builder webClientBuilder;

    public AccountServiceImpl(@Autowired WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Flux<AccountHolder> getAllAccounts() {
        return webClientBuilder.build()
                .get()
                .uri("accountholders/accounts")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(AccountHolder.class));
    }

    @Override
    public Mono<AccountHolder> getAccountById(Long accountNumber) {
        return webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("accountholders/account")
                        .queryParam("accountNumber", accountNumber)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(AccountHolder.class));
    }

    @Override
    public Mono<AccountHolder> createAccount(AccountHolder accountHolder) {
        return webClientBuilder.build()
                .post()
                .uri("accountholders/account")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(accountHolder), AccountHolder.class)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(AccountHolder.class));
    }

    @Override
    public Mono<AccountHolder> updateAccount(AccountHolder accountHolder) {
        return webClientBuilder.build()
                .put()
                .uri("accountholders/account")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(accountHolder), AccountHolder.class)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(AccountHolder.class));
    }

    @Override
    public Mono<Void> deleteAccount(Long accountNumber) {
        return webClientBuilder.build()
                .delete()
                .uri(uriBuilder -> uriBuilder.path("accountholders/account")
                        .queryParam("accountNumber", accountNumber)
                        .build())
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(Void.class));
    }
}