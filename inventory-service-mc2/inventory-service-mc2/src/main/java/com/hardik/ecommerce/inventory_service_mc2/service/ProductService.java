package com.hardik.ecommerce.inventory_service_mc2.service;

import com.hardik.ecommerce.inventory_service_mc2.dto.ProductDTO;
import com.hardik.ecommerce.inventory_service_mc2.entity.Product;
import com.hardik.ecommerce.inventory_service_mc2.repository.ProductRepository;
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


}
