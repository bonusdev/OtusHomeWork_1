package com.bonusgaming.homework_1

import android.util.Log
import com.bonusgaming.homework_1.data.WebRepo
import com.bonusgaming.homework_1.data.pojo.Hit
import com.bonusgaming.homework_1.data.pojo.ResponseData
import com.bonusgaming.homework_1.list_items.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Model @Inject constructor() : Contract.BaseModel<Item> {

    @Inject
    lateinit var webRepo: WebRepo

    override var currentItem: Item = Item()

    init {
        App.appComponent.inject(this)
        Log.e(TAG, "init MODEL $currentItem")
    }

    /* Suspend функция для получения данныз через Kotlin Coroutines*/
    override suspend fun getDataList(currentPage: Int): List<Item> {

        Log.e(TAG, "getDataList called")

        var response: Response<ResponseData>? = null
        withContext(Dispatchers.IO) {
            response = webRepo.apiInterface
                .getRestApiData(page = currentPage)
                .execute()
        }
        Log.e(TAG, "response.isSuccessful = ${response?.isSuccessful}")

        return if (response?.isSuccessful == true) {
            response!!.body()!!.hits.map { it.fillItem() }
        } else emptyList()
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