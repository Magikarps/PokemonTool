package com.example.pokemontool.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemontool.database.Team

object DataManager {
    fun getTeamList(): LiveData<List<Team>> {
        // TODO: dummy data
        val teamL = MutableLiveData<List<Team>>()
        var temp = mutableListOf<Team>()
        temp.add(
            Team(
                0L,
                "Team 1",
                "Magikarp",
                "Magikarp",
                "Magikarp",
                "Magikarp",
                null,
                null
            )
        )
        temp.add(
            Team(
                0L,
                "Team 2",
                "Pikachu",
                "Pikachu",
                "Pikachu",
                "Pikachu",
                "Pikachu",
                "Pikachu"
            )
        )
        teamL.value = temp
        return teamL
    }
}