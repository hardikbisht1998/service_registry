package com.hardik.ecommerce.order_service_mc1.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long id;
    private List<OrderRequestItemDTO> items;
    private BigDecimal totalPrice;
}
