package com.cleonildo.supermakert.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSummary {

    @JsonProperty("product_id")
    private Long id;

    @JsonProperty("product_name")
    private String name;

    @JsonProperty("product_price")
    private Double price;

    @JsonProperty("product_quantity")
    private Integer quantity;

    @JsonProperty("product_definition")
    private String definition;
}