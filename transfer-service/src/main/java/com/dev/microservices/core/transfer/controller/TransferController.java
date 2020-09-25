package com.dev.microservices.core.transfer.controller;

import com.dev.microservices.core.transfer.model.TransferModel;
import com.dev.microservices.core.transfer.model.response.TransactionDetailResponse;
import com.dev.microservices.core.transfer.service.TransferService;
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
@RequestMapping("/transfer-service")
public class TransferController {

    private final TransferService transferService;

    public TransferController(@Autowired @Qualifier("transferService") TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping(value = "/transfer", consumes = { APPLICATION_JSON_VALUE })
    public Mono<TransactionDetailResponse> transfer(@RequestBody Mono<TransferModel> transfer) {
        return transfer.flatMap(transferService::transfer);
    }
}