package com.lambdaschool.basicandroidnetworking.di

import com.lambdaschool.basicandroidnetworking.retrofit.AdviceAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    private const val BASE_URL = "https://api.adviceslip.com/"

    @Singleton
    @Provides
    @JvmStatic
    fun provideRetrofitInstance() : Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    @JvmStatic
    fun provideAdvice(retrofit: Retrofit) =
        retrofit.create(AdviceAPI::class.java)
}