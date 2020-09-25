package com.dev.microservices.core.transfer.service.impl;

import com.dev.microservices.core.transfer.model.TransferModel;
import com.dev.microservices.core.transfer.model.response.TransactionDetailResponse;
import com.dev.microservices.core.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service("transferService")
public class TransferServiceImpl implements TransferService {

    private final WebClient.Builder webClientBuilder;

    public TransferServiceImpl(@Autowired WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<TransactionDetailResponse> transfer(TransferModel transfer) {
        return webClientBuilder.build()
                .post()
                .uri("transactions/transfer")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(Mono.just(transfer), TransferModel.class)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(TransactionDetailResponse.class));
    }
}