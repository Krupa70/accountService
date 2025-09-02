package com.kp.accountService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class H2Config {
    // No need to define DataSource bean manually
    // Spring Boot will auto-configure it using values from application.yml
}