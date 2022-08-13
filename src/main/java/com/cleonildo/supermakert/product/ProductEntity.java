package com.cleonildo.supermakert.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 88920L;

    @Id
    @Column(name = "_id", nullable = false)
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_definition", columnDefinition="TEXT")
    private String definition;

}