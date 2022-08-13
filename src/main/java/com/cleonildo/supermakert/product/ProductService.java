package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductEntity> getListProduct() {
        return this.productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ProductEntity getProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }
}