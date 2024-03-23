package com.github.javashop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;
import java.util.UUID;

@Entity
@DynamicUpdate
@Data
@SQLDelete(sql = "UPDATE products SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull private String name;
    private String description;
    @NotNull private String code;
    @NotNull private boolean isDeleted = false;

    @OneToMany(mappedBy = CategoryProduct_.PRODUCT, cascade = CascadeType.ALL)
    private Set<CategoryProduct> categoryProducts;
}