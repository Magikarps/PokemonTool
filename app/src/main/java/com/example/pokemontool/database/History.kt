package com.example.pokemontool.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    var historyId: Long = 0L,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "win")
    var win: Boolean,
    @ColumnInfo(name = "team")
    var team: String,
    @ColumnInfo(name = "opPokemon1")
    var opPokemon1: String,
    @ColumnInfo(name = "opPokemon2")
    var opPokemon2: String?,
    @ColumnInfo(name = "opPokemon3")
    var opPokemon3: String?,
    @ColumnInfo(name = "opPokemon4")
    var opPokemon4: String?,
    @ColumnInfo(name = "opPokemon5")
    var opPokemon5: String?,
    @ColumnInfo(name = "opPokemon6")
    var opPokemon6: String?
)