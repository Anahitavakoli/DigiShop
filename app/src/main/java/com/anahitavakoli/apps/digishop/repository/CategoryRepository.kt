package com.anahitavakoli.apps.digishop.repository

import com.anahitavakoli.apps.digishop.data.DataOrException
import com.anahitavakoli.apps.digishop.model.BaseCategories
import com.anahitavakoli.apps.digishop.network.ProductApi
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api : ProductApi) {

    private val dataOrException = DataOrException<BaseCategories,Boolean,Exception>()

    suspend fun getAllCategories() : DataOrException<BaseCategories,Boolean,Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getCategories()

            if(dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading = false
            }
        }
        catch (exception : Exception){
            dataOrException.e = exception
        }
        return dataOrException
    }
}