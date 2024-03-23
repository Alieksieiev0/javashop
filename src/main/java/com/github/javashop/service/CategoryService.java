package com.github.javashop.service;

import com.github.javashop.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<CategoryDto> findAll();

    public CategoryDto findById(UUID id);

    public CategoryDto save(CategoryDto categoryDto);

    public CategoryDto update(UUID id, CategoryDto categoryDto);

    public void deleteById(UUID id);

    public void addProduct(UUID id, UUID productId);

    public void removeProduct(UUID id, UUID productId);
}
