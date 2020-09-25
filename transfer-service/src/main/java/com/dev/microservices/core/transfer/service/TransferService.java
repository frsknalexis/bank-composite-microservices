package com.dev.microservices.core.transfer.service;

import com.dev.microservices.core.transfer.model.TransferModel;
import com.dev.microservices.core.transfer.model.response.TransactionDetailResponse;
import reactor.core.publisher.Mono;

public interface TransferService {

    Mono<TransactionDetailResponse> transfer(TransferModel transfer);
}