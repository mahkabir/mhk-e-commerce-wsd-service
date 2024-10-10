package com.mhk.wsd.ecommerce.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@Configuration
public class FlywayConfig {

    @Value("${spring.flyway.enabled}")
    private boolean flywayEnabled;

    @Bean
    public CommandLineRunner migrateDatabase(DataSource dataSource) {
        return args -> {
            if (flywayEnabled) {
                waitForDatabase(dataSource);
                Flyway flyway = Flyway.configure().dataSource(dataSource).load();
                flyway.migrate();
            }
        };
    }

    private void waitForDatabase(DataSource dataSource) {
        int maxRetries = 10;
        int retryCount = 0;
        while (retryCount < maxRetries) {
            try (Connection connection = dataSource.getConnection()) {
                if (connection.isValid(1)) {
                    return;
                }
            } catch (SQLException e) {
                retryCount++;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ignored) {
                }
            }
        }
        throw new IllegalStateException("Database is not ready after max retries");
    }
}

