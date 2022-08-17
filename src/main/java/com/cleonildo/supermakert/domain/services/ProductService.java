package com.cleonildo.supermakert.domain.services;

import com.cleonildo.supermakert.domain.entities.ProductEntity;
import com.cleonildo.supermakert.api.mapper.ProductDetails;
import com.cleonildo.supermakert.api.mapper.ProductSummary;
import com.cleonildo.supermakert.domain.repositories.ProductRepository;
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

        return this.modelToDetails(productEntity);
    }

    @Transactional(readOnly = true)
    public ProductSummary saveProduct(ProductSummary productDetails) {
        ProductEntity productEntity = this.modelMapper.map(productDetails, ProductEntity.class);

        return this.modelToSummary(this.productRepository.saveAndFlush(productEntity));
    }

    @Transactional
    public ProductDetails updateProduct(Long id, ProductDetails productDetailsBody) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);
        productEntity.setEditedAt();
        this.productRepository.saveAndFlush(productEntity);
        return detailsToModel(productDetailsBody, productEntity);

        return this.modelToDetails(this.productRepository.saveAndFlush(productEntity));
    }

    private ProductDetails modelToDetails(ProductEntity productEntity) {
        return this.modelMapper.map(productEntity, ProductDetails.class);
    }

    private ProductSummary modelToSummary(ProductEntity productEntity) {
        return this.modelMapper.map(productEntity, ProductSummary.class);
    }

    private ProductEntity detailsToModel(ProductSummary productDetails) {
        return this.modelMapper.map(productDetails, ProductEntity.class);
    }
}