package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getListProduct() {
        List<ProductEntity> lisOfProducts = this.productService.getListProduct();

       return ResponseEntity.ok(lisOfProducts);
    }
}