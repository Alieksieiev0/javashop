package com.github.javashop.mapper.impl;

import com.github.javashop.dto.CategoryDto;
import com.github.javashop.dto.ProductDto;
import com.github.javashop.mapper.ProductMapper;
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
public class ProductMapperImpl implements ProductMapper {

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
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        List<CategoryDto> list = categoryProductSetToCategoryDtoList( product.getCategoryProducts() );
        if ( list != null ) {
            productDto.setCategories( list );
        }
        if ( product.getCode() != null ) {
            productDto.setCode( product.getCode() );
        }
        if ( product.getDescription() != null ) {
            productDto.setDescription( product.getDescription() );
        }
        if ( product.getId() != null ) {
            productDto.setId( product.getId() );
        }
        if ( product.getName() != null ) {
            productDto.setName( product.getName() );
        }

        return productDto;
    }

    @Override
    public List<ProductDto> toDtos(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    @Override
    public Product toModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        if ( productDto.getCode() != null ) {
            product.setCode( productDto.getCode() );
        }
        if ( productDto.getDescription() != null ) {
            product.setDescription( productDto.getDescription() );
        }
        if ( productDto.getId() != null ) {
            product.setId( productDto.getId() );
        }
        if ( productDto.getName() != null ) {
            product.setName( productDto.getName() );
        }

        return product;
    }

    @Override
    public List<Product> toModels(List<ProductDto> productDtos) {
        if ( productDtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDtos.size() );
        for ( ProductDto productDto : productDtos ) {
            list.add( toModel( productDto ) );
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

    protected List<CategoryDto> categoryProductSetToCategoryDtoList(Set<CategoryProduct> set) {
        if ( set == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( set.size() );
        for ( CategoryProduct categoryProduct : set ) {
            list.add( toCategoryDto( categoryProduct ) );
        }

        return list;
    }
}
