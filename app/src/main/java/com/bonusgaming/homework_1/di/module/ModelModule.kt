package com.bonusgaming.homework_1.di.module

import com.bonusgaming.homework_1.Model
import com.bonusgaming.homework_1.data.WebRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {

    @Singleton
    @Provides
    fun getModel() = Model()

    @Singleton
    @Provides
    fun getWebRepo() = WebRepo()


}