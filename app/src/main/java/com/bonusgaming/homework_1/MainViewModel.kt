package com.bonusgaming.homework_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bonusgaming.homework_1.list_items.Item
import kotlinx.coroutines.*

/* Extension функция для преобразования элементов */
class MainViewModel : Contract.BaseViewModel() {
    override fun getCurrentItem(): Item {
        return data.currentItem
    }

    override fun getOnClickLiveData() = onClickItem

    override fun onClick(item: Item) {
        data.currentItem = item
        onClickItem.value = item
    }

    /* LiveData для databinding с View */
    private val listItems = MutableLiveData<List<Item>>()
    private val onClickItem = MutableLiveData<Item>()

    private lateinit var webJob: Job

    /* Инициализируем поля и выполняем запрос на сервер */
    init {
        data = App.appComponent.getModel()
        makeWeb()
    }

    /* Получем данные через Kotlin Coroutines */
    private fun makeWeb() {
        webJob = GlobalScope.launch(Dispatchers.Main) {
            val list = mutableListOf<Item>()
            withContext(Dispatchers.IO) {
                list.addAll(App.appComponent.getModel().getDataList(1))
            }
            listItems.value = list
        }
    }

    override fun getListItemsLiveData(): LiveData<List<Item>> = listItems

    /* Отменяем Job при вызове onCleared*/
    override fun onCleared() {
        webJob.cancel()

    }
}
