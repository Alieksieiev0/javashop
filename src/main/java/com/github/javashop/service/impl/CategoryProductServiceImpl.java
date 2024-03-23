package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.CATEGORY_PRODUCT_DOES_NOT_EXIST;

import com.github.javashop.model.Category;
import com.github.javashop.model.CategoryProduct;
import com.github.javashop.model.Product;
import com.github.javashop.repository.CategoryProductRepository;
import com.github.javashop.service.CategoryProductService;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;

    @Override
    public void saveByForeignKeys(UUID categoryId, UUID productId) {
        Category category = new Category();
        category.setId(categoryId);

        Product product = new Product();
        product.setId(productId);

        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setCategory(category);
        categoryProduct.setProduct(product);

        categoryProductRepository.save(categoryProduct);
    }

    @Override
    public void deleteByForeignKeys(UUID categoryId, UUID productId) {
        CategoryProduct categoryProduct =
                categoryProductRepository
                        .findByCategoryIdAndProductId(categoryId, productId)
                        .orElseThrow(
                                () -> new EntityNotFoundException(CATEGORY_PRODUCT_DOES_NOT_EXIST));
        categoryProductRepository.delete(categoryProduct);
    }
}
