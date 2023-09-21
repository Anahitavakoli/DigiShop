package com.anahitavakoli.apps.digishop.di

import com.anahitavakoli.apps.digishop.network.ProductApi
import com.anahitavakoli.apps.digishop.repository.ProductRepository
import com.anahitavakoli.apps.digishop.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideShopApi() : ProductApi{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideShopRepository(api: ProductApi) = ProductRepository(api)

}