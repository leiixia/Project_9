package com.example.AssessmentMservice.config.Feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class FeignConfig {
    @Value("${security.username}")
    String username;
    @Value("${security.password}")
    String password;

    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor()
    {
        return new BasicAuthRequestInterceptor("username", "password");
    }

    @Bean
    public RestClient.Builder restCLientBuilder(){
        return RestClient.builder();
    }
}
