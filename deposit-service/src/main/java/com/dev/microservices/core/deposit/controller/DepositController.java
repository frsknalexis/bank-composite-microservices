package com.dev.microservices.core.deposit.controller;

import com.dev.microservices.core.deposit.model.DepositModel;
import com.dev.microservices.core.deposit.model.response.TransactionDetailResponse;
import com.dev.microservices.core.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/deposit-service")
public class DepositController {

    private final DepositService depositService;

    public DepositController(@Autowired @Qualifier("depositService") DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping(value = "/deposit", consumes = { APPLICATION_JSON_VALUE },
            produces = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> deposit(@RequestBody Mono<DepositModel> deposit) {
        return deposit.flatMap(depositService::deposit);
    }
}