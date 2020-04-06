package com.example.pokemontool.network

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemontool.database.Team

object RepositoryManager {
    fun getTeam(teamId: Long): Team? {
        // TODO: dummy data
        val data = getTeamList()
        return data.value?.get(teamId.toInt())
    }

    fun getTeamList(): LiveData<List<Team>> {
        // TODO: dummy data
        val teamL = MutableLiveData<List<Team>>()
        var temp = mutableListOf<Team>()
        temp.add(
            Team(
                0L,
                "Team 1",
                false,
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
                1L,
                "Team 2",
                true,
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

    fun submitTeam(team: Team) {


    }
}