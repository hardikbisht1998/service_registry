package com.hardik.ecommerce.discovery_service_mc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceMc2Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceMc2Application.class, args);
	}

}
