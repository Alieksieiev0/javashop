package com.github.javashop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends BaseDto {
    private String name;
    private String description;
    private String code;
    private Double price;
    private List<CategoryDto> categories;
}
