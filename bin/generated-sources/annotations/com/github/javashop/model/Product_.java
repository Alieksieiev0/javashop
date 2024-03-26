package com.github.javashop.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(Product.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2024-03-25T22:43:33.639019038+02:00")
public abstract class Product_ {

	
	/**
	 * @see com.github.javashop.model.Product#categoryProducts
	 **/
	public static volatile SetAttribute<Product, CategoryProduct> categoryProducts;
	
	/**
	 * @see com.github.javashop.model.Product#code
	 **/
	public static volatile SingularAttribute<Product, String> code;
	
	/**
	 * @see com.github.javashop.model.Product#isDeleted
	 **/
	public static volatile SingularAttribute<Product, Boolean> isDeleted;
	
	/**
	 * @see com.github.javashop.model.Product#name
	 **/
	public static volatile SingularAttribute<Product, String> name;
	
	/**
	 * @see com.github.javashop.model.Product#description
	 **/
	public static volatile SingularAttribute<Product, String> description;
	
	/**
	 * @see com.github.javashop.model.Product#id
	 **/
	public static volatile SingularAttribute<Product, UUID> id;
	
	/**
	 * @see com.github.javashop.model.Product
	 **/
	public static volatile EntityType<Product> class_;

	public static final String CATEGORY_PRODUCTS = "categoryProducts";
	public static final String CODE = "code";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

