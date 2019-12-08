package com.bonusgaming.homework_1.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/* Класс для взаимодействия через Retrofit */
@Singleton
class WebRepo @Inject constructor()  {

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