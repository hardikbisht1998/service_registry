package com.hardik.ecommerce.order_service_mc1.clients;


import com.hardik.ecommerce.order_service_mc1.dto.OrderRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="inventory-service-mc2", path = "/inventory")
public interface InventoryOpenFeignClient {

    @PutMapping("/products/reduce-stock")
    Double reduceStocks(@RequestBody OrderRequestDTO orderRequestDTO);


}
