package com.dev.microservices.core.transaction.repository;

import com.dev.microservices.core.transaction.entity.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository("transactionRepository")
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {

}