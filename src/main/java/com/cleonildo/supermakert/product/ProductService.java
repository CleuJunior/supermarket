package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<ProductDetails> getListProduct() {
        return this.productRepository.findAll()
                .stream()
                .map(this::modelToDetails)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductDetails getProductById(Long id) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);

        return modelToDetails(productEntity);
    }

    @Transactional(readOnly = true)
    public void saveProduct(ProductDetails productDetails) {
        this.productRepository.saveAndFlush(detailsToModel(productDetails));

    }

    private ProductDetails modelToDetails(ProductEntity productEntity) {
        return this.modelMapper.map(productEntity, ProductDetails.class);
    }

    private ProductEntity detailsToModel(ProductDetails productDetails) {
        return this.modelMapper.map(productDetails, ProductEntity.class);
    }
}