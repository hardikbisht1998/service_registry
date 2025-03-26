package com.hardik.ecommerce.order_service_mc1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private OrderStatus orderStatus;

        private Double totalPrice;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
        private List<OrderItem> items;



}
