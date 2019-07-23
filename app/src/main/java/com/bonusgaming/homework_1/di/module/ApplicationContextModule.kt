package com.bonusgaming.homework_1.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(private val appContext: Context) {

    @Singleton
    @Provides
    fun getApplicationContext(): Context = appContext
}