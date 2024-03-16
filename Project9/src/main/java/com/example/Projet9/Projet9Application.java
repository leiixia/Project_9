package com.example.Projet9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients("com.example.Projet9")
public class Projet9Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet9Application.class, args);
	}

}
