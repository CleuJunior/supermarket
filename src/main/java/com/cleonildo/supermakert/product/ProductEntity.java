package com.cleonildo.supermakert.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString
@AllArgsConstructor
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 88920L;

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @JsonProperty("product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    @Getter
    @Setter
    @JsonProperty("product_name")
    private String name;

    @Column(name = "product_price", nullable = false)
    @Getter
    @Setter
    @JsonProperty("product_price")
    private Double price;

    @Column(name = "product_quantity", nullable = false)
    @Getter
    @Setter
    @JsonProperty("product_quantity")
    private Integer quantity;

    @Column(name = "product_definition", columnDefinition="TEXT")
    @Getter
    @Setter
    @JsonProperty("product_definition")
    private String definition;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter
    @JsonProperty("created_at")
    private Instant createdAt;

    @Column(name = "edited_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter
    @JsonProperty("edited_at")
    private Instant editedAt;

    public ProductEntity() {
        this.createdAt = Instant.now();
    }
}