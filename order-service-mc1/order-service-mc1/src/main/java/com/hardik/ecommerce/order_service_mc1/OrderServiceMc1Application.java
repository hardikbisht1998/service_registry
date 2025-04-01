package com.hardik.ecommerce.order_service_mc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceMc1Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceMc1Application.class, args);
	}

}
