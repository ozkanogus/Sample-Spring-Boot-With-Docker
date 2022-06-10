package com.interview.ibm.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan(basePackages = "com.interview.ibm.domain")
@EnableJpaRepositories(basePackages = "com.interview.ibm.repos")
@EnableTransactionManagement
public class DomainConfig {
}
