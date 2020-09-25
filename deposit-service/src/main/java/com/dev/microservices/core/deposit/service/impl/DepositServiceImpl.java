package com.dev.microservices.core.deposit.service.impl;

import com.dev.microservices.core.deposit.model.DepositModel;
import com.dev.microservices.core.deposit.model.response.TransactionDetailResponse;
import com.dev.microservices.core.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service("depositService")
public class DepositServiceImpl implements DepositService {

    private final WebClient.Builder webClientBuilder;

    public DepositServiceImpl(@Autowired WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<TransactionDetailResponse> deposit(DepositModel deposit) {
        return webClientBuilder.build()
                .post()
                .uri("transactions/deposit")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(Mono.just(deposit), DepositModel.class)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(TransactionDetailResponse.class));
    }
}