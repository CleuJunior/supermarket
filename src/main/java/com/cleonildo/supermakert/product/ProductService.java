package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> getListProduct() {
        this.productRepository.deleteAll();

        ProductEntity product01 = new ProductEntity(null, "Product 1", 10.0, 10, "Product 1 definition");
        ProductEntity product02 = new ProductEntity(null, "Product 2", 20.0, 20, "Product 2 definition");
        ProductEntity product03 = new ProductEntity(null, "Product 3", 30.0, 30, "Product 3 definition");
        ProductEntity product04 = new ProductEntity(null, "Product 4", 30.0, 30, null);
        ProductEntity product05 = new ProductEntity(null, "Product 5", 30.0, 30, null);

        this.productRepository.saveAll(List.of(product01, product02, product03, product04, product05));

        return this.productRepository.findAll();
    }

}