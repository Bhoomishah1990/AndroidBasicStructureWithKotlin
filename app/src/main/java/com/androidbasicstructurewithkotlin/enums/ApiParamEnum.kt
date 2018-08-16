package com.androidbasicstructurewithkotlin.enums

/**
 * Created by Darshna Desai
 */

enum class ApiParamEnum(val value: String) {

    /* HEADERS */
    AUTHENTICATION("Authorization"),
    SECURE_STAMP("SecureStamp"),
    CONTENT_TYPE("Content-Type"),

    DEVICE_TYPE("device_type"),
    DEVICE_TOKEN("device_token"),

    USER_ID("user_id"),
    ACCESS_TOKEN("access_token"),

    PASSWORD("password"),
    EMAIL("email")
}
