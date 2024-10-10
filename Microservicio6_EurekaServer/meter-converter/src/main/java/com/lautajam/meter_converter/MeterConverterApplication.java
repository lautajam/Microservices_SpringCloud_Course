package com.lautajam.meter_converter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class MeterConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterConverterApplication.class, args);
	}

}
