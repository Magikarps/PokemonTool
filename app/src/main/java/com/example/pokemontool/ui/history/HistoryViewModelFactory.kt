package com.example.pokemontool.ui.history

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemontool.database.HistoryDao

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the SleepDatabaseDao and context to the ViewModel.
 */
class HistoryViewModelFactory(
    private val dataSource: HistoryDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
