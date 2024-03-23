package com.github.javashop.mapper;

import com.github.javashop.config.MapperConfig;
import com.github.javashop.dto.CategoryDto;
import com.github.javashop.dto.ProductDto;
import com.github.javashop.model.CategoryProduct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface CategoryProductMapper {

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = ".", source = "categoryProduct.product")
    ProductDto toProductDto(CategoryProduct categoryProduct);

    @Mapping(target = "products", ignore = true)
    @Mapping(target = ".", source = "categoryProduct.category")
    CategoryDto toCategoryDto(CategoryProduct categoryProduct);
}
