package com.github.javashop.service;

import com.github.javashop.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<ProductDto> findAll();

    public ProductDto findById(UUID id);

    public ProductDto save(ProductDto productDto);

    public ProductDto update(UUID id, ProductDto productDto);

    public void deleteById(UUID id);
}
