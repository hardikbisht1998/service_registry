package com.hardik.ecommerce.order_service_mc1.repository;

import com.hardik.ecommerce.order_service_mc1.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
