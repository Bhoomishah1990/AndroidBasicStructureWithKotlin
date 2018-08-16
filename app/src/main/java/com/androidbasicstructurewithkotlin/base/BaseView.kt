package com.androidbasicstructurewithkotlin.base

import android.content.Context

/**
 * Base view any view must implement.
 */
interface BaseView {
    /**
     * @return the Context in which the application is running
     */
    fun getContext(): Context

    /**
     * @return whether the device has internet or not
     */
    fun hasInternet(): Boolean

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}