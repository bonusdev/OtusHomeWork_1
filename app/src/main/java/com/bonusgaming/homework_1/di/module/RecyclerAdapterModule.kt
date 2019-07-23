package com.bonusgaming.homework_1.di.module

import android.content.Context
import android.widget.ListAdapter
import com.bonusgaming.homework_1.R
import com.bonusgaming.homework_1.list_items.ListAdapterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RecyclerAdapterModule() {

    @Singleton
    @Provides
    fun getAdapter()= ListAdapterImpl()
}