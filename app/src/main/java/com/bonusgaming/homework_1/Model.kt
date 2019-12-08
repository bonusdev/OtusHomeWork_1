package com.bonusgaming.homework_1

import android.util.Log
import com.bonusgaming.homework_1.data.WebRepo
import com.bonusgaming.homework_1.data.pojo.Hit
import com.bonusgaming.homework_1.data.pojo.ResponseData
import com.bonusgaming.homework_1.di.component.DaggerAppComponent
import com.bonusgaming.homework_1.di.component.DaggerArchitectureComponent
import com.bonusgaming.homework_1.list_items.Item
import retrofit2.Response
import javax.inject.Inject


class Model : Contract.BaseModel<Item> {

    @Inject
    lateinit var webRepo:WebRepo

    override var currentItem: Item = Item()

    init {
        DaggerArchitectureComponent.create().inject(this)
        Log.e(TAG, "init MODEL $currentItem")
    }

    /* Suspend функция для получения данныз через Kotlin Coroutines*/
    override suspend fun getDataList(currentPage: Int): List<Item> {

        Log.e(TAG, "getDataList called")

        val result: MutableList<Item> = mutableListOf()
        val response: Response<ResponseData> = webRepo.apiInterface
            .getRestApiData(page = currentPage)
            .execute()

        Log.e(TAG, "response.isSuccessful = ${response.isSuccessful}")

        if (response.isSuccessful) {
            Log.e(TAG, "hits.size = ${response.body()?.hits?.size} ")
            response.body()?.hits?.forEach { result.add(it.fillItem()) }
        }

        return result
    }

    /* Extension функция для преобразования элементов */
    private fun Hit.fillItem(): Item {
        return Item(
            webformatURL,
            largeImageURL,
            user,
            userImageURL,
            likes,
            views
        )
    }
}