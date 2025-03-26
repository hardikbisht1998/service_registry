package com.hardik.ecommerce.inventory_service_mc2.repository;


import com.hardik.ecommerce.inventory_service_mc2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
