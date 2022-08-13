package com.cleonildo.supermakert.product;

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
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 88920L;

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_definition", columnDefinition="TEXT")
    private String definition;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(name = "edited_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant editedAt;

}