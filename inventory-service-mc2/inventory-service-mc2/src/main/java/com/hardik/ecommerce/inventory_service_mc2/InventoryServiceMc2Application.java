package com.hardik.ecommerce.inventory_service_mc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InventoryServiceMc2Application {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceMc2Application.class, args);
	}

}
