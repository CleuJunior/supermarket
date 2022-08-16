package com.cleonildo.supermakert.product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 88920L;

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "product_name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "product_price", nullable = false)
    @Getter
    @Setter
    private Double price;

    @Column(name = "product_quantity", nullable = false)
    @Getter
    @Setter
    private Integer quantity;

    @Column(name = "product_definition", columnDefinition="TEXT")
    @Getter
    @Setter
    private String definition;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter
    private Instant createdAt;

    @Column(name = "edited_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter
    private Instant editedAt;

    public ProductEntity() {
        this.createdAt = Instant.now();
    }

    public void setEditedAt() {
        this.editedAt = Instant.now();
    }
}