package com.example.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {
    companion object {
        const val SELECTED_ITEM = "SELECTED_ITEM"
    }

    private fun changeAppBar() {
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    var selectedItem: String? = "Не выбрано"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///
        changeAppBar()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        if (extras != null) selectedItem = extras.getString(SELECTED_ITEM)
    }

    override fun onResume() {
        super.onResume()
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        fragment?.setSelectedItem(selectedItem)
    }
}