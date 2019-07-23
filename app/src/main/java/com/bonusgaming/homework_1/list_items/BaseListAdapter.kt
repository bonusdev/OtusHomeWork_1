package com.bonusgaming.homework_1.list_items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bonusgaming.homework_1.R

/* Базовый класс адптера. Повторящейся логика выделена сюда */
abstract class BaseListAdapter<T : BaseItem> : RecyclerView.Adapter<BaseListAdapter.ItemHolder<T>>() {
    private var listItems: List<T> = mutableListOf()

    fun addItems(newItems: List<T>) {
        listItems = listItems + newItems
        notifyDataSetChanged()
    }

    abstract fun getHolderInstance(view: View): ItemHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return getHolderInstance(view)
    }

    override fun getItemCount(): Int = listItems.size


    override fun onBindViewHolder(itemHolder: ItemHolder<T>, position: Int) {
        itemHolder.inflateData(listItems[position])
    }

    abstract class ItemHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun inflateData(item: T)
    }

}

