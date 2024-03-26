package com.github.javashop.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(Role.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2024-03-25T22:43:33.642417303+02:00")
public abstract class Role_ {

	
	/**
	 * @see com.github.javashop.model.Role#isDeleted
	 **/
	public static volatile SingularAttribute<Role, Boolean> isDeleted;
	
	/**
	 * @see com.github.javashop.model.Role#name
	 **/
	public static volatile SingularAttribute<Role, String> name;
	
	/**
	 * @see com.github.javashop.model.Role#id
	 **/
	public static volatile SingularAttribute<Role, UUID> id;
	
	/**
	 * @see com.github.javashop.model.Role
	 **/
	public static volatile EntityType<Role> class_;
	
	/**
	 * @see com.github.javashop.model.Role#users
	 **/
	public static volatile SetAttribute<Role, User> users;

	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

