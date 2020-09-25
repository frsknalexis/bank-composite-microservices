package com.dev.microservices.core.withdraw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawModel implements Serializable {

    private static final long serialVersionUID = 3506801587938545173L;

    private Long accountNumber;

    private BigDecimal withdrawAmount;

    private String withdrawType;
}