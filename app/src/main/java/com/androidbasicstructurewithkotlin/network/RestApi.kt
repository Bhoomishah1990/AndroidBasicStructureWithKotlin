package com.androidbasicstructurewithkotlin.network

import com.androidbasicstructurewithkotlin.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * The interface which provides methods to get result of webservices
 */
interface RestApi {
    /**
     * Get the list of the pots from the API
     */
    @GET
    fun getPosts(@Url url: String): Observable<List<Post>>
}