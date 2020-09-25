package com.dev.microservices.core.transaction.service.impl;

import com.dev.microservices.core.transaction.entity.Transaction;
import com.dev.microservices.core.transaction.model.response.TransactionDetailResponse;
import com.dev.microservices.core.transaction.repository.AccountRepository;
import com.dev.microservices.core.transaction.repository.TransactionRepository;
import com.dev.microservices.core.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(@Autowired @Qualifier("accountRepository") AccountRepository accountRepository,
        @Autowired @Qualifier("transactionRepository") TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    @Override
    public Mono<TransactionDetailResponse> deposit(Transaction transaction) {
        return Mono.just(transaction)
                .map(t -> {
                    t.setTransactionId(UUID.randomUUID().toString());
                    t.setTransactionDate(LocalDateTime.now());
                    return t;
                })
                .flatMap(transactionRepository::save)
                .then(accountRepository.findById(transaction.getAccountNumber())
                        .map(accountHolder -> {
                            BigDecimal updatedBalance = accountHolder.getAccountBalance()
                                    .add(transaction.getDepositAmount());
                            accountHolder.setAccountBalance(updatedBalance);
                            return accountHolder;
                        })
                )
                .flatMap(accountRepository::save)
                .map(accountHolder -> TransactionDetailResponse.builder()
                        .status("SUCCESS")
                        .transactionAmount(transaction.getDepositAmount())
                        .transactionId(transaction.getTransactionId())
                        .transactionDate(transaction.getTransactionDate())
                        .transactionType("DEPOSIT")
                        .build());
    }

    @Transactional
    @Override
    public Mono<TransactionDetailResponse> transfer(Transaction transaction) {
        return Mono.just(transaction)
                .map(t -> {
                    t.setTransactionId(UUID.randomUUID().toString());
                    t.setTransactionDate(LocalDateTime.now());
                    return t;
                })
                .flatMap(transactionRepository::save)
                .then(accountRepository.findById(transaction.getAccountNumber())
                        .map(accountHolder -> {
                            BigDecimal updatedBalance = accountHolder.getAccountBalance()
                                    .add(transaction.getDepositAmount());
                            accountHolder.setAccountBalance(updatedBalance);
                            return accountHolder;
                        })
                )
                .flatMap(accountRepository::save)
                .then(accountRepository.findById(transaction.getSourceAccountNumber())
                        .map(sourceAccountHolder -> {
                            BigDecimal updatedBalance = sourceAccountHolder.getAccountBalance()
                                    .subtract(transaction.getDepositAmount());
                            sourceAccountHolder.setAccountBalance(updatedBalance);
                            return sourceAccountHolder;
                        })
                )
                .flatMap(accountRepository::save)
                .map(sourceAccountHolder -> TransactionDetailResponse.builder()
                        .status("SUCCESS")
                        .transactionAmount(transaction.getDepositAmount())
                        .transactionId(transaction.getTransactionId())
                        .transactionDate(transaction.getTransactionDate())
                        .transactionType("TRANSFER")
                        .build());
    }

    @Transactional
    @Override
    public Mono<TransactionDetailResponse> withdraw(Transaction transaction) {
        return Mono.just(transaction)
                .map(t -> {
                    t.setTransactionId(UUID.randomUUID().toString());
                    t.setTransactionDate(LocalDateTime.now());
                    return t;
                })
                .flatMap(transactionRepository::save)
                .then(accountRepository.findById(transaction.getAccountNumber())
                        .map(accountHolder -> {
                            BigDecimal updatedBalance = accountHolder.getAccountBalance()
                                    .subtract(transaction.getWithdrawAmount());
                            accountHolder.setAccountBalance(updatedBalance);
                            return accountHolder;
                        })
                )
                .flatMap(accountRepository::save)
                .map(accountHolder -> TransactionDetailResponse.builder()
                        .status("SUCCESS")
                        .transactionAmount(transaction.getWithdrawAmount())
                        .transactionId(transaction.getTransactionId())
                        .transactionDate(transaction.getTransactionDate())
                        .transactionType("WITHDRAW")
                        .build());
    }

    @Override
    public Flux<Transaction> getTransactions(Long accountNumber) {
        return transactionRepository.findAllById(Mono.just(accountNumber));
    }
}