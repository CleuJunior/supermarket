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
                .map(pdc -> this.modelMapper.map(pdc, ProductDetails.class))
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductDetails getProductById(Long id) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);

        return this.modelMapper.map(productEntity, ProductDetails.class);
    }

    @Transactional(readOnly = true)
    public ProductSummary saveProduct(ProductSummary productSummary) {
        ProductEntity productEntity = this.modelMapper.map(productSummary, ProductEntity.class);
        this.productRepository.saveAndFlush(productEntity);

        return this.modelMapper.map(productEntity, ProductSummary.class);
    }

    @Transactional
    public ProductDetails updateProduct(Long id, ProductDetails productDetailsBody) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);

        productDetailsBody.setId(id);
        this.productRepository.saveAndFlush(this.modelMapper.map(productDetailsBody, ProductEntity.class));
        productEntity.setEditedAt();

        return this.modelMapper.map(productEntity, ProductDetails.class);
    }
}