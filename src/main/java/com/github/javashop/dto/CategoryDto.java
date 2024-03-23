package com.github.javashop.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CategoryDto {
    private UUID id;
    private String name;
    private String description;
    private List<ProductDto> products;
}
