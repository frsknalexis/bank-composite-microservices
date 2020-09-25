package com.dev.microservices.core.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "tbl_account_holder")
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = -5720859352041604349L;

    @Id
    @Column(value = "account_number")
    private Long accountNumber;

    @Column(value = "account_first_name")
    private String accountFirstName;

    @Column(value = "account_last_name")
    private String accountLastName;

    @Column(value = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(value = "account_type")
    private String accountType;

    @Column(value = "account_start_date")
    private LocalDateTime accountStartDate;

    @Column(value = "account_balance")
    private BigDecimal accountBalance;

    @Column(value = "mobile_number")
    private String mobileNumber;

    @Column(value = "address")
    private String address;
}