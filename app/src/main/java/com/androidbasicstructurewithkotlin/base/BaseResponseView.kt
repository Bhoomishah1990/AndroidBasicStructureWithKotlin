package com.androidbasicstructurewithkotlin.base

/**
 * Created by imobdev-darshna on 27/3/18.
 */

/**
 * Base Response view any view that calls at least one api, must implement.
 */
interface BaseResponseView<in T> : BaseView {

    /**
     * Callback to get the response from the called api
     */
    fun onSuccess(response: T)

    /**
     * Callback to get the failure message from the called api
     */
    fun onFailure(message: String)

}