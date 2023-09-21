package com.anahitavakoli.apps.digishop.repository

import com.anahitavakoli.apps.digishop.data.DataOrException
import com.anahitavakoli.apps.digishop.model.HomeModel
import com.anahitavakoli.apps.digishop.network.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api : ProductApi) {

    private val dataOrException = DataOrException<HomeModel,Boolean,Exception>()

    suspend fun getHome() : DataOrException<HomeModel,Boolean,Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getHomeInfo()

            if(dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading = false
            }

        }
        catch (exception: Exception){
            dataOrException.e = exception
        }

        return dataOrException
    }
}