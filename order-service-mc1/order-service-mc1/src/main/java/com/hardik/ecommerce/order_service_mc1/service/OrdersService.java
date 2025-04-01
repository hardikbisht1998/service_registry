package com.hardik.ecommerce.order_service_mc1.service;

import com.hardik.ecommerce.order_service_mc1.clients.InventoryOpenFeignClient;
import com.hardik.ecommerce.order_service_mc1.dto.OrderRequestDTO;
import com.hardik.ecommerce.order_service_mc1.entity.OrderItem;
import com.hardik.ecommerce.order_service_mc1.entity.OrderStatus;
import com.hardik.ecommerce.order_service_mc1.entity.Orders;
import com.hardik.ecommerce.order_service_mc1.repository.OrdersRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;
    private final InventoryOpenFeignClient inventoryOpenFeignClient;

    public List<OrderRequestDTO> getAllOrders(){
        log.info("Fetching all orders");
        List<Orders> orders=ordersRepository.findAll();
        return orders.stream().map(x->modelMapper.map(x,OrderRequestDTO.class)).toList();
    }

    public OrderRequestDTO getOrderById(Long id){
        log.info("fetching order with id : {} ",id);
        Orders orders=ordersRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        return modelMapper.map(orders,OrderRequestDTO.class);
    }

//    @Retry(name="inventoryRetry",fallbackMethod = "createOrderFallBack")
    @CircuitBreaker(name="inventoryCircuitBreaker", fallbackMethod = "createOrderFallBack")
//    @RateLimiter(name = "inventoryRateLimiter",fallbackMethod = "createOrderFallBack")
    public OrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO){
        log.info("Called at {}",System.currentTimeMillis());
        Double totalPrice= inventoryOpenFeignClient.reduceStocks(orderRequestDTO);
        Orders orders=modelMapper.map(orderRequestDTO,Orders.class);
        for(OrderItem orderItem: orders.getItems()){
            orderItem.setOrder(orders);
        }
        orders.setTotalPrice(totalPrice);
        orders.setOrderStatus(OrderStatus.COMPLETED);

        Orders savedOrders = ordersRepository.save(orders);
        return modelMapper.map(savedOrders,OrderRequestDTO.class);

    }

    public OrderRequestDTO createOrderFallBack(OrderRequestDTO orderRequestDTO,Throwable throwable) {
    log.error("Fallback occured due to : {}",throwable.getMessage());
    return new OrderRequestDTO();

    }

}
