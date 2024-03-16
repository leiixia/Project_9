package com.example.Projet9.config.Feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

    @Bean
    public CustomErrorDecoder mCustomeErrorDecoder(){
        return new CustomErrorDecoder();
    }
}
