package com.bonusgaming.homework_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bonusgaming.homework_1.list_items.Item

/* Контракт для взаимодействия по архитектруе MVVM */
sealed class Contract {

    abstract class BaseActivityView : AppCompatActivity() {

        lateinit var viewModel: BaseViewModel

        /* Метод для нициализации */
        abstract fun init()

        /* Метод для инициализации графических элементов */
        abstract fun initViews()

        override fun onCreate(savedInstanceState: Bundle?) {
            viewModel = App.appComponent.getMainViewModel()
            super.onCreate(savedInstanceState)
            initViews()
            init()
        }
    }

    abstract class BaseViewModel : ViewModel() {
        lateinit var data: BaseModel<Item>

        abstract fun getCurrentItem(): Item?

        abstract fun onClick(item: Item)

        abstract fun getListItemsLiveData(): LiveData<List<Item>>
        abstract fun getOnClickLiveData(): LiveData<Item>
    }

    interface BaseModel<T> {
        var currentItem: T

        suspend fun getDataList(currentPage: Int): List<T>
    }


}