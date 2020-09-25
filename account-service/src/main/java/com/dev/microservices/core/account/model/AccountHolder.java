package com.dev.microservices.core.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = -4644034315757572739L;

    private Long accountNumber;

    private String accountFirstName;

    private String accountLastName;

    private LocalDate dateOfBirth;

    private String accountType;

    private LocalDateTime accountStartDate;

    private BigDecimal accountBalance;

    private String mobileNumber;

    private String address;
}