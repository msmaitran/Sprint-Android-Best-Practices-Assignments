package com.lambdaschool.dagger2demo.di

import dagger.Module
import dagger.Provides

@Module
object DateModule {

    @Provides
    fun providesDateExample(): DateExampleContract {
        return DateExampleTest()
    }
}