package com.github.javashop.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(User.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor", date = "2024-03-25T22:33:04.44669926+02:00")
public abstract class User_ {

	
	/**
	 * @see com.github.javashop.model.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.github.javashop.model.User#role
	 **/
	public static volatile SingularAttribute<User, Role> role;
	
	/**
	 * @see com.github.javashop.model.User#isDeleted
	 **/
	public static volatile SingularAttribute<User, Boolean> isDeleted;
	
	/**
	 * @see com.github.javashop.model.User#id
	 **/
	public static volatile SingularAttribute<User, UUID> id;
	
	/**
	 * @see com.github.javashop.model.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.github.javashop.model.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see com.github.javashop.model.User#username
	 **/
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String IS_DELETED = "isDeleted";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

