package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/create")
    public ResponseEntity<ProductDetails> createProduct(@RequestBody ProductDetails productBody) {
        this.productService.saveProduct(productBody);



//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(productBody.getId()).toUri();

//        return ResponseEntity.created(uri).body(productBody);
        return ResponseEntity.ok(productBody);
    }
}