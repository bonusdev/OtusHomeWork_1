package com.bonusgaming.homework_1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bonusgaming.homework_1.list_items.ListAdapterImpl
import javax.inject.Inject

/* Создаем RecyclerView для отображения списка. Адаптер получаем из компонента Dagger 2 */
class ListFragment : Fragment() {

    @Inject
    lateinit var listImpl: ListAdapterImpl

    override fun onAttach(context: Context?) {
        App.appComponent.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler: RecyclerView = view.findViewById(R.id.recycler_view)
        recycler.adapter = listImpl
        val layoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = layoutManager
        return view
    }
}