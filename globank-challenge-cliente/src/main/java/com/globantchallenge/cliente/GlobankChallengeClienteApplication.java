package com.globantchallenge.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GlobankChallengeClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobankChallengeClienteApplication.class, args);
	}

}
