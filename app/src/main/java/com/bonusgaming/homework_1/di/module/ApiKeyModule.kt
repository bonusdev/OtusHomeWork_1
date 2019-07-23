package com.bonusgaming.homework_1.di.module

import android.content.Context
import com.bonusgaming.homework_1.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiKeyModule(private val appContext: Context) {

    @Singleton
    @Provides
    fun getApiKey(): String = appContext.resources.getString(R.string.key)
}