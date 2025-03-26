package com.hardik.ecommerce.inventory_service_mc2.controller;

import com.hardik.ecommerce.inventory_service_mc2.dto.ProductDTO;
import com.hardik.ecommerce.inventory_service_mc2.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private final DiscoveryClient discoveryClient;

    private final RestClient restClient;


    @GetMapping("/fetchOrders")
    public String fetchFromOrderService(){
        ServiceInstance orderService=discoveryClient.getInstances("order-service-mc1").get(0);
        return  restClient.get().uri(orderService.getUri()+"/api/v/orders/helloOrders")
                .retrieve()
                .body(String.class);

    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllInventory(){
        List<ProductDTO> productDTOS=productService.getAllInventory();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getInventoryById(@PathVariable Long id){
        ProductDTO productDTO=productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

}
