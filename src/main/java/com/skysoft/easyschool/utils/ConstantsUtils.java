package com.skysoft.easyschool.utils;

public interface ConstantsUtils {
    String SPRING_PROFILE_DEVELOPMENT = "dev";
    String SPRING_PROFILE_PRODUCTION = "prod";
    String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";
    String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    String SYSTEM_ACCOUNT = "system";
    String DEFAULT_LANGUAGE = "en";
    String ANONYMOUS_USER = "anonymoususer";
    String FORMAT_TWO_STRING = "%s%s";
    String PREFIX_ROLE = "ROLE_";
    String ADMIN_USER_LOGIN = "admin";
    String ADMIN_ACCOUNT = "Administrateur";
}
