package com.anahitavakoli.apps.digishop.network

import com.anahitavakoli.apps.digishop.model.BaseCategories
import com.anahitavakoli.apps.digishop.model.HomeModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("home.php")
    suspend fun getHomeInfo() : HomeModel

    @GET("getCategories.php")
    suspend fun getCategories() : BaseCategories

}