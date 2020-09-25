package com.dev.microservices.core.deposit.service;

import com.dev.microservices.core.deposit.model.DepositModel;
import com.dev.microservices.core.deposit.model.response.TransactionDetailResponse;
import reactor.core.publisher.Mono;

public interface DepositService {

    Mono<TransactionDetailResponse> deposit(DepositModel deposit);
}