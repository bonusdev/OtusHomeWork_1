package com.bonusgaming.homework_1.data

import com.bonusgaming.homework_1.App
import com.bonusgaming.homework_1.data.pojo.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

/* Интерфейс для Retrofit */
interface ApiInterface {

    /***
     *
     *   Примеры запросов:
     *   https://pixabay.com/api/?key={KEY}&image_type=photo&page=2&safesearch=true&per_page=6&page=2
     *   https://pixabay.com/api/?key={KEY}&q=&image_type=photo&pretty=true&orientation=vertical&category=music&colors=&order=&page=1&per_page=3
     *   https://pixabay.com/api/?key={KEY}&q=&pretty=true&image_type=photo&safesearch=true&orientation=vertical&category=&colors=&order=&page=1&per_page=30
     *
     ***/

    /* Получению json */
    @GET("/api/")
    fun getRestApiData(
        @Query("key") key: String = App.appComponent.getApiKey(),
        @Query("q") search: String = Settings.NONE,
        @Query("orientation") orientation: String = Settings.ORIENTATION_VERTICAL,
        @Query("category") category: String = Settings.NONE,
        @Query("colors") colors: String = Settings.NONE,
        @Query("order") order: String = Settings.NONE,
        @Query("image_type") imageType: String = Settings.IMAGE_TYPE,
        @Query("safesearch") safeSearch: Boolean = false,
        @Query("editors_choice") editorsChoice: Boolean = true,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int
    ): Call<ResponseData>
}

