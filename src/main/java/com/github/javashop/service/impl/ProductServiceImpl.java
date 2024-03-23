package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.PRODUCT_DOES_NOT_EXIST;

import com.github.javashop.dto.ProductDto;
import com.github.javashop.mapper.ProductMapper;
import com.github.javashop.repository.ProductRepository;
import com.github.javashop.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        return mapper.toDtos(productRepository.findAll());
    }

    @Override
    public ProductDto findById(UUID id) {
        return mapper.toDto(
                productRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new NoSuchElementException(PRODUCT_DOES_NOT_EXIST + id)));
    }

    @Override
    public ProductDto save(ProductDto productDto) {

        System.out.println("DTO: " + productDto);
        System.out.println(mapper.toModel(productDto));
        return mapper.toDto(productRepository.save(mapper.toModel(productDto)));
    }

    @Override
    public ProductDto update(UUID id, ProductDto productDto) {
        productRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(PRODUCT_DOES_NOT_EXIST + id));
        productDto.setId(id);
        return mapper.toDto(productRepository.save(mapper.toModel(productDto)));
    }

    @Override
    public void deleteById(UUID id) {
        productRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException(PRODUCT_DOES_NOT_EXIST + id));
        productRepository.deleteById(id);
    }
}
