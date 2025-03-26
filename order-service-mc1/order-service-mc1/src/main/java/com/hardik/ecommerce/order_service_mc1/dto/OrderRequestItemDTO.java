package com.hardik.ecommerce.order_service_mc1.dto;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;

}
