package ru.test.java.planflight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ru.test.java.planflight.repository")
public class JpaConfig {
}
