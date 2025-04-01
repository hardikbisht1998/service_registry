package com.hardik.ecommerce.order_service_mc1.controller;

import com.hardik.ecommerce.order_service_mc1.clients.InventoryOpenFeignClient;
import com.hardik.ecommerce.order_service_mc1.dto.OrderRequestDTO;
import com.hardik.ecommerce.order_service_mc1.service.OrdersService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
public class OrdersController {

    private final OrdersService ordersService;



    @GetMapping("/helloOrders")
    public String helloOrders(){
        return "Hello from order Services";
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDTO>> getAllOrders(HttpServletRequest httpServletRequest){
        log.info("Feting for all controller");
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDTO> getOrderById(@PathVariable Long id){
        log.info("Feting for all controller");
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderRequestDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        OrderRequestDTO orderRequestDTO1 = ordersService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(orderRequestDTO1);


    }
}
