package com.github.javashop.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private String code;
    private List<CategoryDto> categories;
}
