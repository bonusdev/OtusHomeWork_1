package com.bonusgaming.homework_1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/* Создаем RecyclerView для отображения списка. Адаптер получаем из компонента Dagger 2 */
class ListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container,false)
        val recycler: RecyclerView = view.findViewById(R.id.recycler_view)
        recycler.adapter = App.appComponent.getListImpl()
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = RecyclerView.VERTICAL
        recycler.layoutManager = layoutManager
        return view
    }
}