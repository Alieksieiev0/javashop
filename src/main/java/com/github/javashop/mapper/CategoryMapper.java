package com.github.javashop.mapper;

import com.github.javashop.config.MapperConfig;
import com.github.javashop.dto.CategoryDto;
import com.github.javashop.model.Category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper extends CategoryProductMapper {

    @Mapping(target = "products", source = "category.categoryProducts")
    CategoryDto toDto(Category category);

    List<CategoryDto> toDtos(List<Category> categories);

    @Mapping(target = "categoryProducts", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Category toModel(CategoryDto categoryDto);

    List<Category> toModels(List<CategoryDto> categoryDtos);
}
