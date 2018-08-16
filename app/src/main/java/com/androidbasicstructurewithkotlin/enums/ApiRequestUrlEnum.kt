package com.androidbasicstructurewithkotlin.enums

import com.androidbasicstructurewithkotlin.utils.Constants

/**
 * Created by Darshna Desai
 */

enum class ApiRequestUrlEnum(private val value: String) {

    GET_POSTS("posts");

    fun getValue(): String {
        return Constants.BASE_URL + value
    }
}