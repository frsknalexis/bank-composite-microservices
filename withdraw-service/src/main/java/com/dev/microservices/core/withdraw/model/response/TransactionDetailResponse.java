package com.dev.microservices.core.withdraw.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetailResponse implements Serializable {

    private static final long serialVersionUID = 5053418046080208145L;

    private String transactionId;

    private String status;

    private LocalDateTime transactionDate;

    private String transactionType;

    private BigDecimal transactionAmount;
}