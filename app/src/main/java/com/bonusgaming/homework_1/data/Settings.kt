package com.bonusgaming.homework_1.data

import com.bonusgaming.homework_1.App


/* Класс с настройками для запросов https://pixbay.com */
object Settings {

    val BASE_URL = "https://pixabay.com/"

    val IMAGE_TYPE = "photo"

    val NONE = ""

    val ORIENTATION_VERTICAL = "vertical"

    val ORIENTATION_GORIZONTAL = "horizontal"

    val SAFE_SEARCH = true

    val EDITORS_CHOICE = false

    val PER_PAGE = 30

    val KEY_API: String = App.appComponent.getApiKey()

}

