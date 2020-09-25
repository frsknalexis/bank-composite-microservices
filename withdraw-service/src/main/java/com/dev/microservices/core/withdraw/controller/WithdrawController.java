package com.dev.microservices.core.withdraw.controller;

import com.dev.microservices.core.withdraw.model.WithdrawModel;
import com.dev.microservices.core.withdraw.model.response.TransactionDetailResponse;
import com.dev.microservices.core.withdraw.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/withdraw-service")
public class WithdrawController {

    private final WithdrawService withdrawService;

    public WithdrawController(@Autowired @Qualifier("withdrawService") WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @PostMapping(value = "/withdraw", consumes = { APPLICATION_JSON_VALUE },
        produces = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> withdraw(@RequestBody Mono<WithdrawModel> withdraw) {
        return withdraw.flatMap(withdrawService::withdraw);
    }
}