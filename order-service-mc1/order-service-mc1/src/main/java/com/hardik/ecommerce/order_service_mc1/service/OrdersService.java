package com.hardik.ecommerce.order_service_mc1.service;

import com.hardik.ecommerce.order_service_mc1.dto.OrderRequestDTO;
import com.hardik.ecommerce.order_service_mc1.entity.Orders;
import com.hardik.ecommerce.order_service_mc1.repository.OrdersRepository;
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
}
