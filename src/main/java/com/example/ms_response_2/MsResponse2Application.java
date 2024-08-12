package com.example.ms_response_2;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class MsResponse2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsResponse2Application.class, args);
	}

}


