package com.lambdaschool.dagger2demo

import android.app.Application
import com.lambdaschool.dagger2demo.di.DaggerDateComponent
import com.lambdaschool.dagger2demo.di.DateComponent
import com.lambdaschool.dagger2demo.di.DateModule

class DaggerDemoApplication: Application() {

    lateinit var dateComponent: DateComponent
    override fun onCreate() {
        super.onCreate()

        dateComponent = DaggerDateComponent.builder()
            .dateModule(DateModule)
            .build()

    }
}