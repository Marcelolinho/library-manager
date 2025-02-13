package com.example.library_manager.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WebClient restTemplate() {
        return new Web();
    }
}
