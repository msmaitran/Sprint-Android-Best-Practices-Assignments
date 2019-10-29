package com.lambdaschool.mortgagecalculator

import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class Numbers(val data: Array<Int>)

interface Retrocalls{
    @GET("jsonI.php")
    fun getNumbers(@Query("length")length: Int,
                   @Query("type")type:String): Single<Numbers>
}

object Retro{
    fun create(): Retrocalls {
        return Retrofit.Builder()
            .baseUrl("https://qrng.anu.edu.au/API/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Retrocalls::class.java)
    }
}