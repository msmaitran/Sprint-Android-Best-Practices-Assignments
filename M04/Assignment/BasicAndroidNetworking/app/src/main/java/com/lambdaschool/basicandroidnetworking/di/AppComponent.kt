package com.lambdaschool.basicandroidnetworking.di

import com.lambdaschool.basicandroidnetworking.retrofit.RetrofitActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])

interface AppComponent {

    fun inject(retrofitActivity: RetrofitActivity)
}