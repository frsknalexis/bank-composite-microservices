package com.dev.microservices.core.withdraw.service;

import com.dev.microservices.core.withdraw.model.WithdrawModel;
import com.dev.microservices.core.withdraw.model.response.TransactionDetailResponse;
import reactor.core.publisher.Mono;

public interface WithdrawService {

    Mono<TransactionDetailResponse> withdraw(WithdrawModel withdrawModel);
}