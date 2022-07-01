package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import java.util.ArrayList


class ListFragment() : Fragment() {

    internal interface OnFragmentSendDataListener {
        fun onSendData(data: String?)
    }

    private var fragmentSendDataListener: OnFragmentSendDataListener? = null
    var countries = arrayOf<String?>("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")

    //
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentSendDataListener = context as OnFragmentSendDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " должен реализовывать интерфейс OnFragmentInteractionListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        // получаем элемент ListView
        val countriesList = view.findViewById<ListView>(R.id.countriesList)

        // создаем адаптер
        val adapter: Any =
            ArrayAdapter<Any?>((context)!!, android.R.layout.simple_list_item_1, countries)
        // устанавливаем для списка адаптер
        countriesList.adapter = adapter as ListAdapter?
        // добавляем для списка слушатель
        countriesList.onItemClickListener =
            OnItemClickListener { parent, _, position, _ -> // получаем выбранный элемент
                val selectedItem: String = parent.getItemAtPosition(position) as String
                // Посылаем данные Activity
                fragmentSendDataListener!!.onSendData(selectedItem)
            }


        return view
    }
}