package com.github.javashop.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(CategoryProduct.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2024-03-25T22:33:04.447560642+02:00")
public abstract class CategoryProduct_ {

	
	/**
	 * @see com.github.javashop.model.CategoryProduct#product
	 **/
	public static volatile SingularAttribute<CategoryProduct, Product> product;
	
	/**
	 * @see com.github.javashop.model.CategoryProduct#isDeleted
	 **/
	public static volatile SingularAttribute<CategoryProduct, Boolean> isDeleted;
	
	/**
	 * @see com.github.javashop.model.CategoryProduct#id
	 **/
	public static volatile SingularAttribute<CategoryProduct, UUID> id;
	
	/**
	 * @see com.github.javashop.model.CategoryProduct#category
	 **/
	public static volatile SingularAttribute<CategoryProduct, Category> category;
	
	/**
	 * @see com.github.javashop.model.CategoryProduct
	 **/
	public static volatile EntityType<CategoryProduct> class_;

	public static final String PRODUCT = "product";
	public static final String IS_DELETED = "isDeleted";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

