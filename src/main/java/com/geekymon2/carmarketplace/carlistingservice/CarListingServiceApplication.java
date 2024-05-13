package com.geekymon2.carmarketplace.carlistingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.geekymon2.carmarketplace.carlistingservice",
		"com.geekymon2.carmarketplace.core.autoconfiguration"})
public class CarListingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarListingServiceApplication.class, args);
	}
}
