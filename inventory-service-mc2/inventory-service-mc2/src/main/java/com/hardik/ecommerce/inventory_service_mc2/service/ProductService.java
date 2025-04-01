package com.hardik.ecommerce.inventory_service_mc2.service;

import com.hardik.ecommerce.inventory_service_mc2.dto.OrderRequestDTO;
import com.hardik.ecommerce.inventory_service_mc2.dto.OrderRequestItemDTO;
import com.hardik.ecommerce.inventory_service_mc2.dto.ProductDTO;
import com.hardik.ecommerce.inventory_service_mc2.entity.Product;
import com.hardik.ecommerce.inventory_service_mc2.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllInventory(){
        log.info("Fetching all inventory item");
        List<Product> inventories= productRepository.findAll();
        return inventories.stream().map(x->modelMapper.map(x,ProductDTO.class)).collect(Collectors.toList());

    }
    public ProductDTO getProductById(Long id){

        log.info("Fetching all inventory item");
        Optional<Product> product=productRepository.findById(id);
        return product.map(x->modelMapper.map(x,ProductDTO.class)).orElseThrow(()->new RuntimeException());
    }

    @Transactional
    public Double reduceStock(OrderRequestDTO orderRequestDTO) {
        log.info("reducing the stock ");
        Double totalPrice=0.0;
        for(OrderRequestItemDTO orderRequestItemDTOs: orderRequestDTO.getItems()){
            Long productId=orderRequestItemDTOs.getProductId();
            Integer quantity=orderRequestItemDTOs.getQuantity();
             Product product=productRepository.findById(productId)
                    .orElseThrow(()->new RuntimeException("Product not found with id "+productId));

            if(product.getStock()<quantity){
                throw new RuntimeException("Product with less quantity found with id "+productId);
            }

            product.setStock(product.getStock()-quantity);
            totalPrice+=quantity*product.getPrice();

        }

        return totalPrice;
    }
}
