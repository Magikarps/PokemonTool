package com.example.pokemontool.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class Team {
    var teamId: Long? = null
    var teamName: String? = null
    var pokemon1: String? = null
    var pokemon2: String? = null
    var pokemon3: String? = null
    var pokemon4: String? = null
    var pokemon5: String? = null
    var pokemon6: String? = null

    constructor()

    constructor(
        teamId: Long?,
        teamName: String? = null,
        pokemon1: String? = null,
        pokemon2: String? = null,
        pokemon3: String? = null,
        pokemon4: String? = null,
        pokemon5: String? = null,
        pokemon6: String? = null
    ) {
        this.teamId = teamId
        this.teamName = teamName
        this.pokemon1 = pokemon1
        this.pokemon2 = pokemon2
        this.pokemon3 = pokemon3
        this.pokemon4 = pokemon4
        this.pokemon5 = pokemon5
        this.pokemon6 = pokemon6
    }

}