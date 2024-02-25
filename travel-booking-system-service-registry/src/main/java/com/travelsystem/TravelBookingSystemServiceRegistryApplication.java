package com.travelsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TravelBookingSystemServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelBookingSystemServiceRegistryApplication.class, args);
	}
}