package com.dev.microservices.core.deposit.model;

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
public class DepositModel implements Serializable {

    private static final long serialVersionUID = 7837770275022088891L;

    private Long accountNumber;

    private BigDecimal depositAmount;

    private String depositType;
}