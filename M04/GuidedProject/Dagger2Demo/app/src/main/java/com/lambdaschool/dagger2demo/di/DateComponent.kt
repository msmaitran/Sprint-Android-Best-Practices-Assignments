package com.lambdaschool.dagger2demo.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DateModule::class])
interface DateComponent {

    fun inject(daggerActivity: DaggerActivity)
}