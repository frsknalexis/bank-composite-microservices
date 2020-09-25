package com.dev.microservices.core.withdraw.service.impl;

import com.dev.microservices.core.withdraw.model.WithdrawModel;
import com.dev.microservices.core.withdraw.model.response.TransactionDetailResponse;
import com.dev.microservices.core.withdraw.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service("withdrawService")
public class WithdrawServiceImpl implements WithdrawService {

    private final WebClient.Builder webClientBuilder;

    public WithdrawServiceImpl(@Autowired WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<TransactionDetailResponse> withdraw(WithdrawModel withdrawModel) {
        return webClientBuilder.build()
                .post()
                .uri("transactions/withdraw")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(Mono.just(withdrawModel), WithdrawModel.class)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(TransactionDetailResponse.class));
    }
}