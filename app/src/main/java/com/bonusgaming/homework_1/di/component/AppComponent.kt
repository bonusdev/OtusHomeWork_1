package com.bonusgaming.homework_1.di.component

import com.bonusgaming.homework_1.MainViewModel
import com.bonusgaming.homework_1.Model
import com.bonusgaming.homework_1.data.WebRepo
import com.bonusgaming.homework_1.di.module.ApiKeyModule
import com.bonusgaming.homework_1.di.module.ModelModule
import com.bonusgaming.homework_1.di.module.RecyclerAdapterModule
import com.bonusgaming.homework_1.di.module.ViewModelModule
import com.bonusgaming.homework_1.list_items.ListAdapterImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, ApiKeyModule::class, RecyclerAdapterModule::class, ModelModule::class])
interface AppComponent {
    fun getMainViewModel(): MainViewModel
    fun getWebRepo(): WebRepo
    fun getApiKey(): String
    fun getModel(): Model
    fun getListImpl(): ListAdapterImpl

}