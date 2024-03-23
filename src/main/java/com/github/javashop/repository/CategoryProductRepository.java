package com.github.javashop.repository;

import com.github.javashop.model.CategoryProduct;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, UUID> {
    Optional<CategoryProduct> findByCategoryIdAndProductId(UUID categoryId, UUID productId);
}
