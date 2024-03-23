package com.github.javashop.mapper;

import com.github.javashop.config.MapperConfig;
import com.github.javashop.dto.ProductDto;
import com.github.javashop.model.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface ProductMapper extends CategoryProductMapper {

    @Mapping(target = "categories", source = "product.categoryProducts")
    ProductDto toDto(Product product);

    List<ProductDto> toDtos(List<Product> products);

    @Mapping(target = "categoryProducts", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Product toModel(ProductDto productDto);

    List<Product> toModels(List<ProductDto> productDtos);
}
