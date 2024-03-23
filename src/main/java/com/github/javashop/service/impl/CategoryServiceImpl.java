package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.CATEGORY_DOES_NOT_EXIST;
import static com.github.javashop.config.Constants.PRODUCT_DOES_NOT_EXIST;

import com.github.javashop.dto.CategoryDto;
import com.github.javashop.mapper.CategoryMapper;
import com.github.javashop.model.Category;
import com.github.javashop.repository.CategoryRepository;
import com.github.javashop.repository.ProductRepository;
import com.github.javashop.service.CategoryProductService;
import com.github.javashop.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryProductService categoryProductService;

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtos(categoryRepository.findAll());
    }

    @Override
    public CategoryDto findById(UUID id) {
        return categoryMapper.toDto(findCategoryByIdOrThrow(id));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toModel(categoryDto)));
    }

    @Override
    public CategoryDto update(UUID id, CategoryDto categoryDto) {
        findCategoryByIdOrThrow(id);
        categoryDto.setId(id);
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toModel(categoryDto)));
    }

    @Override
    public void deleteById(UUID id) {
        findCategoryByIdOrThrow(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public void addProduct(UUID id, UUID productId) {
        findCategoryByIdOrThrow(id);
        productRepository
                .findById(productId)
                .orElseThrow(() -> new NoSuchElementException(PRODUCT_DOES_NOT_EXIST + productId));
        categoryProductService.saveByForeignKeys(id, productId);
    }

    @Override
    public void removeProduct(UUID id, UUID productId) {
        findCategoryByIdOrThrow(id);
        productRepository
                .findById(productId)
                .orElseThrow(() -> new NoSuchElementException(PRODUCT_DOES_NOT_EXIST + productId));
        categoryProductService.deleteByForeignKeys(id, productId);
    }

    private Category findCategoryByIdOrThrow(UUID id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(CATEGORY_DOES_NOT_EXIST + id));
    }
}
