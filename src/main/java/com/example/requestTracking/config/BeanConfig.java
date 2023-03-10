package com.example.requestTracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {
    @Bean
    BCryptPasswordEncoder getPasswordEncoder(){return new BCryptPasswordEncoder(8);}
}
