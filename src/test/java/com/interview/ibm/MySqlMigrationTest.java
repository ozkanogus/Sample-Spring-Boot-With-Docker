package com.interview.ibm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "MYSQL_TEST_ENABLED", matches = "true")
class MySqlMigrationTest {

    @Test
    void flywayMigrationAndHibernateValidationSucceed() {
    }
}
