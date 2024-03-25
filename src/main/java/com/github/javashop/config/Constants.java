package com.github.javashop.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Calendar;

public final class Constants {
    private Constants() {}

    public static final String PRODUCT_DOES_NOT_EXIST = "Product with provided id does not exist:";
    public static final String CATEGORY_DOES_NOT_EXIST =
            "Category with provided id does not exist:";
    public static final String CATEGORY_PRODUCT_DOES_NOT_EXIST =
            "There is no connection between provided category and product";
    public static final int JWT_UNIT_TYPE = Calendar.MINUTE;
    public static final int JWT_DURATION_IN_UNIT_TYPE = 360;
    public static final String JWT_SECRET_KEY = Dotenv.load().get("JWT_SECRET_KEY");
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
}
