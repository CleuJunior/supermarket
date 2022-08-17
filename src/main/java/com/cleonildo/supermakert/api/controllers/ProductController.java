package com.cleonildo.supermakert.api.controllers;

import com.cleonildo.supermakert.api.mapper.ProductDetails;
import com.cleonildo.supermakert.domain.services.ProductService;
import com.cleonildo.supermakert.api.mapper.ProductSummary;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetails>> getListProduct() {
       return ResponseEntity.ok(this.productService.getListProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.getProductById(id));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductDetails> getBookById (@PathVariable Long id, @RequestBody ProductDetails productDetails) {
        return ResponseEntity.ok().body(this.productService.updateProduct(id, productDetails));

    }

    @PostMapping("/create")
    public ResponseEntity<ProductSummary> createProduct(@RequestBody ProductSummary productBody) {
        ProductSummary productDetails = this.productService.saveProduct(productBody);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productDetails.getId()).toUri();

        return ResponseEntity.created(uri).body(productDetails);
    }

}