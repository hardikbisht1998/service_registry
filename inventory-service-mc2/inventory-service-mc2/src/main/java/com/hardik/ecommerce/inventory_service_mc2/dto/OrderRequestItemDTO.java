package com.hardik.ecommerce.inventory_service_mc2.dto;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;

}
