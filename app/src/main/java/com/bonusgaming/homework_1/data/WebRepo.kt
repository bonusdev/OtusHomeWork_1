package com.bonusgaming.homework_1.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* Класс для взаимодействия через Retrofit */
class WebRepo {

    var apiInterface: ApiInterface
        private set

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Settings.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

}