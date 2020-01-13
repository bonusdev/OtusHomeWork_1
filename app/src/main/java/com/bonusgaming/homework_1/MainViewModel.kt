package com.bonusgaming.homework_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bonusgaming.homework_1.list_items.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/* Extension функция для преобразования элементов */
@Singleton
class MainViewModel @Inject constructor() : Contract.BaseViewModel() {

    @Inject
    lateinit var model: Model

    override fun getCurrentItem(): Item {
        return model.currentItem
    }

    override fun getOnClickLiveData() = onClickItem

    override fun onClick(item: Item) {
        model.currentItem = item
        onClickItem.value = item
    }

    /* LiveData для databinding с View */
    private val listItems = MutableLiveData<List<Item>>()
    private val onClickItem = MutableLiveData<Item>()

    /* Инициализируем поля и выполняем запрос на сервер */
    init {
        App.appComponent.inject(this)
        makeWeb()
    }

    /* Получем данные через Kotlin Coroutines, используем viewModelScope из коробки*/
    private fun makeWeb() {
        viewModelScope.launch(Dispatchers.Main) {
            val list = mutableListOf<Item>()
            withContext(Dispatchers.IO) {
                list.addAll(model.getDataList(1))
            }
            listItems.value = list
        }
    }

    override fun getListItemsLiveData(): LiveData<List<Item>> = listItems
}
