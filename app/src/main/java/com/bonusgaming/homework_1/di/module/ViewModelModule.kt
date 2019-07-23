package com.bonusgaming.homework_1.di.module

import com.bonusgaming.homework_1.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun getViewModel() = MainViewModel()
}