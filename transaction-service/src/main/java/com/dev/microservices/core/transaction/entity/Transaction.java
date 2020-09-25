package com.dev.microservices.core.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "tbl_transaction")
public class Transaction implements Serializable, Persistable<Long> {

    private static final long serialVersionUID = 5108608843838275116L;

    @Id
    @Column(value = "account_number")
    private Long accountNumber;

    @Column(value = "deposit_amount")
    private BigDecimal depositAmount;

    @Column(value = "deposit_type")
    private String depositType;

    @Column(value = "source_account_number")
    private Long sourceAccountNumber;

    @Column(value = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(value = "withdraw_amount")
    private BigDecimal withdrawAmount;

    @Column(value = "withdraw_type")
    private String withdrawType;

    @Column(value = "transaction_id")
    private String transactionId;

    @Override
    public Long getId() {
        return getAccountNumber();
    }

    @Override
    public boolean isNew() {
        return true;
    }
}