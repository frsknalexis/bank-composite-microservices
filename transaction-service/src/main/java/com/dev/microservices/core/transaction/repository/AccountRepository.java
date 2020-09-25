package com.dev.microservices.core.transaction.repository;

import com.dev.microservices.core.transaction.entity.AccountHolder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends ReactiveCrudRepository<AccountHolder, Long> {

}