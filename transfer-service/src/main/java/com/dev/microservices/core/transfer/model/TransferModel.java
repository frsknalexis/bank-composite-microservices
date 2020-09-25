package com.dev.microservices.core.transfer.model;

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
public class TransferModel implements Serializable {

    private static final long serialVersionUID = -5446361857969062168L;

    private Long accountNumber;

    private BigDecimal depositAmount;

    private String depositType;

    private Long sourceAccountNumber;
}