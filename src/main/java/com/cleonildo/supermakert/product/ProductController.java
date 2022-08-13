package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetails>> getListProduct() {
        List<ProductDetails> listProductsSummary = this.productService.getListProduct()
                .stream()
                .map(this::convertToDTO)
                .toList();

       return ResponseEntity.ok(listProductsSummary);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable Long id) {
        ProductDetails productSummary = convertToDTO(this.productService.getProductById(id));

        return ResponseEntity.ok(productSummary);
    }

    @PostMapping("/create")


    private ProductDetails convertToDTO(ProductEntity productEntity) {
        return this.modelMapper.map(productEntity, ProductDetails.class);
    }
}