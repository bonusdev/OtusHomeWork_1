package com.bonusgaming.homework_1.di.module

import com.bonusgaming.homework_1.data.Settings
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Settings.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}