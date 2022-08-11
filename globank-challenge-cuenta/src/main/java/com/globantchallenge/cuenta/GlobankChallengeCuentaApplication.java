package com.globantchallenge.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GlobankChallengeCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobankChallengeCuentaApplication.class, args);
	}

}
