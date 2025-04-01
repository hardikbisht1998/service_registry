package com.hardik.ecommerce.inventory_service_mc2.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="order-service-mc1", path = "/orders")
public interface OrdersFeignClient {

    @GetMapping("/core/helloOrders")
    String helloOrders();

}
