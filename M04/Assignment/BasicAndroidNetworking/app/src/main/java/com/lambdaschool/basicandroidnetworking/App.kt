package com.lambdaschool.basicandroidnetworking

import android.app.Application
import com.lambdaschool.basicandroidnetworking.di.AppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
    }

}