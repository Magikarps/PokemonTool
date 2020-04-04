package com.example.pokemontool.ui.team

import androidx.lifecycle.ViewModel
import com.example.pokemontool.Mode
import com.example.pokemontool.database.Team
import kotlinx.coroutines.Job

class TeamDetailViewModel(private val mode: Mode, private val teamId: Long?) : ViewModel() {

    private val viewModelJob = Job()
    private var team: Team? = null

    val doneButtonVisible = false
    val editButtonVisible = true

}