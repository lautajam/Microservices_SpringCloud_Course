package com.lautajam.eurekkasv;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class EurekkasvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekkasvApplication.class, args);
	}

}
