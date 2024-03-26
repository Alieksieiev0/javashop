package com.github.javashop.mapper.impl;

import com.github.javashop.dto.CategoryDto;
import com.github.javashop.dto.ProductDto;
import com.github.javashop.mapper.CategoryMapper;
import com.github.javashop.model.Category;
import com.github.javashop.model.CategoryProduct;
import com.github.javashop.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T22:33:04+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240318-1716, environment: Java 17.0.10 (N/A)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public ProductDto toProductDto(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        String code = categoryProductProductCode( categoryProduct );
        if ( code != null ) {
            productDto.setCode( code );
        }
        String description = categoryProductProductDescription( categoryProduct );
        if ( description != null ) {
            productDto.setDescription( description );
        }
        UUID id = categoryProductProductId( categoryProduct );
        if ( id != null ) {
            productDto.setId( id );
        }
        String name = categoryProductProductName( categoryProduct );
        if ( name != null ) {
            productDto.setName( name );
        }

        return productDto;
    }

    @Override
    public CategoryDto toCategoryDto(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        String description = categoryProductCategoryDescription( categoryProduct );
        if ( description != null ) {
            categoryDto.setDescription( description );
        }
        UUID id = categoryProductCategoryId( categoryProduct );
        if ( id != null ) {
            categoryDto.setId( id );
        }
        String name = categoryProductCategoryName( categoryProduct );
        if ( name != null ) {
            categoryDto.setName( name );
        }

        return categoryDto;
    }

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        List<ProductDto> list = categoryProductSetToProductDtoList( category.getCategoryProducts() );
        if ( list != null ) {
            categoryDto.setProducts( list );
        }
        if ( category.getDescription() != null ) {
            categoryDto.setDescription( category.getDescription() );
        }
        if ( category.getId() != null ) {
            categoryDto.setId( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryDto.setName( category.getName() );
        }

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toDtos(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Category toModel(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryDto.getDescription() != null ) {
            category.setDescription( categoryDto.getDescription() );
        }
        if ( categoryDto.getId() != null ) {
            category.setId( categoryDto.getId() );
        }
        if ( categoryDto.getName() != null ) {
            category.setName( categoryDto.getName() );
        }

        return category;
    }

    @Override
    public List<Category> toModels(List<CategoryDto> categoryDtos) {
        if ( categoryDtos == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDtos.size() );
        for ( CategoryDto categoryDto : categoryDtos ) {
            list.add( toModel( categoryDto ) );
        }

        return list;
    }

    private String categoryProductProductCode(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Product product = categoryProduct.getProduct();
        if ( product == null ) {
            return null;
        }
        String code = product.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String categoryProductProductDescription(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Product product = categoryProduct.getProduct();
        if ( product == null ) {
            return null;
        }
        String description = product.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private UUID categoryProductProductId(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Product product = categoryProduct.getProduct();
        if ( product == null ) {
            return null;
        }
        UUID id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String categoryProductProductName(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Product product = categoryProduct.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String categoryProductCategoryDescription(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Category category = categoryProduct.getCategory();
        if ( category == null ) {
            return null;
        }
        String description = category.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private UUID categoryProductCategoryId(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Category category = categoryProduct.getCategory();
        if ( category == null ) {
            return null;
        }
        UUID id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String categoryProductCategoryName(CategoryProduct categoryProduct) {
        if ( categoryProduct == null ) {
            return null;
        }
        Category category = categoryProduct.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected List<ProductDto> categoryProductSetToProductDtoList(Set<CategoryProduct> set) {
        if ( set == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( set.size() );
        for ( CategoryProduct categoryProduct : set ) {
            list.add( toProductDto( categoryProduct ) );
        }

        return list;
    }
}
