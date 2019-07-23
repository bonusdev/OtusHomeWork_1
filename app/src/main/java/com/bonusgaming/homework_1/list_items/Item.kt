package com.bonusgaming.homework_1.list_items

data class Item(
    val previewUrl: String="",
    val mainUrl: String="",
    val authorName: String="",
    val authorAvatarUrl: String="",
    val likes: Int=0,
    val views: Int=0
) : BaseItem