package com.example.pokemontool.ui.team

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemontool.Mode
import com.example.pokemontool.database.PokemonDao

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the SleepDatabaseDao and context to the ViewModel.
 */
class TeamDetailViewModelFactory(
    private val mode: Mode,
    private val teamId: Long?,
    private val dataSource: PokemonDao
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamDetailViewModel::class.java)) {
            return TeamDetailViewModel(mode, teamId, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
