package com.example.pokemontool.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemontool.network.DataManager

class TeamListViewModel : ViewModel() {
    val teamList = DataManager.getTeamList()

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