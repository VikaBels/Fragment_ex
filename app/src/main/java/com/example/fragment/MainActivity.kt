package com.example.fragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragment.ListFragment.OnFragmentSendDataListener


class MainActivity : AppCompatActivity(), OnFragmentSendDataListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSendData(data: String?) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        if (fragment != null && fragment.isVisible) fragment.setSelectedItem(data) else {
            val intent = Intent(
                applicationContext,
                DetailActivity::class.java
            )
            intent.putExtra(DetailActivity.SELECTED_ITEM, data)
            startActivity(intent)
        }
    }

}