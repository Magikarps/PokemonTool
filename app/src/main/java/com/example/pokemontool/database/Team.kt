package com.example.pokemontool.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
class Team(
    @PrimaryKey(autoGenerate = true)
    var teamId: Long,
    @ColumnInfo(name = "team_name")
    var teamName: String,
    @ColumnInfo(name = "pokemon_1")
    var pokemon1: String,
    @ColumnInfo(name = "pokemon2")
    var pokemon2: String?,
    @ColumnInfo(name = "pokemon3")
    var pokemon3: String?,
    @ColumnInfo(name = "pokemon4")
    var pokemon4: String?,
    @ColumnInfo(name = "pokemon5")
    var pokemon5: String?,
    @ColumnInfo(name = "pokemon6")
    var pokemon6: String?
)