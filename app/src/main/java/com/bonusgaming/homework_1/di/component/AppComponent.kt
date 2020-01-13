package com.bonusgaming.homework_1.di.component

import com.bonusgaming.homework_1.*
import com.bonusgaming.homework_1.data.WebRepo
import com.bonusgaming.homework_1.di.module.ApiKeyModule
import com.bonusgaming.homework_1.di.module.RetrofitModule
import com.bonusgaming.homework_1.list_items.ListAdapterImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiKeyModule::class, RetrofitModule::class])
interface AppComponent {
    fun getApiKey(): String

    fun inject(model: Model)
    fun inject(fragment: ItemFragment)
    fun inject(holder: ListAdapterImpl.HolderImpl)
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragment)
    fun inject(viewModel: MainViewModel)
    fun inject(webRepo: WebRepo)
}