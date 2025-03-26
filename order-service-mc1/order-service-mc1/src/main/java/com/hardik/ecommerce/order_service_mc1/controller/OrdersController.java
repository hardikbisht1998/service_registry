package com.hardik.ecommerce.order_service_mc1.controller;

import com.hardik.ecommerce.order_service_mc1.dto.OrderRequestDTO;
import com.hardik.ecommerce.order_service_mc1.service.OrdersService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
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
}
