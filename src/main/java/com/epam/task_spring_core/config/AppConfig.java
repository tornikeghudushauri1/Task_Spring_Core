package com.epam.task_spring_core.config;

import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.epam.task_spring_core"})
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public InMemoryStorage inMemoryStorage() {
        return new InMemoryStorage();
    }
}