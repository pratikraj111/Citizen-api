package com.RoadIsland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class CitizenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenApiApplication.class, args);
	}

}