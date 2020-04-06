package com.example.pokemontool.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemontool.network.RepositoryManager

class TeamListViewModel : ViewModel() {
    val teamList = RepositoryManager.getTeamList()

    private val _navigateToTeamDetail = MutableLiveData<Long>()
    val navigateToTeamDetail
    get() = _navigateToTeamDetail

    fun onTeamClicked(teamId: Long?) {
        _navigateToTeamDetail.value = teamId
    }

    fun onTeamDetailNavigated() {
        _navigateToTeamDetail.value = null
    }

}