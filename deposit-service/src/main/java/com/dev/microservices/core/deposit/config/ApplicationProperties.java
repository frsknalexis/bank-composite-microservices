package com.dev.microservices.core.deposit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ApplicationProperties {

    @Value("${services.transaction-service.base-url}")
    private String transactionServiceBaseUrl;
}