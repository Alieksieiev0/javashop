package com.github.javashop.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(Category.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2024-03-25T22:43:33.641508412+02:00")
public abstract class Category_ {

	
	/**
	 * @see com.github.javashop.model.Category#categoryProducts
	 **/
	public static volatile SetAttribute<Category, CategoryProduct> categoryProducts;
	
	/**
	 * @see com.github.javashop.model.Category#isDeleted
	 **/
	public static volatile SingularAttribute<Category, Boolean> isDeleted;
	
	/**
	 * @see com.github.javashop.model.Category#name
	 **/
	public static volatile SingularAttribute<Category, String> name;
	
	/**
	 * @see com.github.javashop.model.Category#description
	 **/
	public static volatile SingularAttribute<Category, String> description;
	
	/**
	 * @see com.github.javashop.model.Category#id
	 **/
	public static volatile SingularAttribute<Category, UUID> id;
	
	/**
	 * @see com.github.javashop.model.Category
	 **/
	public static volatile EntityType<Category> class_;

	public static final String CATEGORY_PRODUCTS = "categoryProducts";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

