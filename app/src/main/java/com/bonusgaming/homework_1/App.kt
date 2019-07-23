package com.bonusgaming.homework_1

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bonusgaming.homework_1.di.component.AppComponent
import com.bonusgaming.homework_1.di.component.DaggerAppComponent
import com.bonusgaming.homework_1.di.module.ApiKeyModule
import com.bonusgaming.homework_1.list_items.Item

const val TAG: String = "home_work_1@"

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .apiKeyModule(ApiKeyModule(this))
            .build()

    }
}