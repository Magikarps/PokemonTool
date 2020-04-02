package com.example.pokemontool.ui.history

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.pokemontool.database.HistoryDao

class HistoryViewModel(dataSource: HistoryDao, application: Application) : ViewModel() {
    val database = dataSource

    var historyList = database.getAll()

    fun onHistoryClicked(hId: Long) {

    }
}