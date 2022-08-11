package com.globantchallenge.movimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GlobankChallengeMovimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobankChallengeMovimientoApplication.class, args);
	}

}
