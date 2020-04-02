package com.example.pokemontool.ui.team

import androidx.lifecycle.ViewModel
import com.example.pokemontool.Mode
import com.example.pokemontool.database.Team
import com.example.pokemontool.database.TeamDao
import kotlinx.coroutines.Job

class TeamDetailViewModel(private val mode: Mode, private val teamId: Long?, dataSource: TeamDao) : ViewModel() {
    val database = dataSource

    private val viewModelJob = Job()
    private var team: Team? = null


    fun getTeam() = team

    init {
        teamId?.let { team = database.get(teamId) }
    }

    val doneButtonVisible = false
    val editButtonVisible = true

}