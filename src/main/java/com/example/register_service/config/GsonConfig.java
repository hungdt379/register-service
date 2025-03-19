package com.example.register_service.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting() // Format JSON đẹp hơn
                .disableHtmlEscaping() // Tránh escape ký tự HTML
                .create();
    }
}
