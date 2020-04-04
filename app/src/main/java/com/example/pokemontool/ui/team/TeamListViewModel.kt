package com.example.pokemontool.ui.team

import androidx.lifecycle.ViewModel
import com.example.pokemontool.network.DataManager

class TeamListViewModel : ViewModel() {
    val teamList = DataManager.getTeamList()


}