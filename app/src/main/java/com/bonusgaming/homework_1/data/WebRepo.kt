package com.bonusgaming.homework_1.data

import com.bonusgaming.homework_1.App
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/* Класс для взаимодействия через Retrofit */
@Singleton
class WebRepo @Inject constructor() {

    @Inject lateinit var retrofit:Retrofit

    var apiInterface: ApiInterface
        private set

    init {
        App.appComponent.inject(this)
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

}