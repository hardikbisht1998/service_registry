package com.hardik.ecommerce.inventory_service_mc2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String title;

    private Double price;

    private Integer stock;
}
