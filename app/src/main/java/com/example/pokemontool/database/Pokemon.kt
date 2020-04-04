package com.example.pokemontool.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    val pokemonId: String,
    @ColumnInfo(name = "name_jp")
    val nameJp: String,
    @ColumnInfo(name = "name_en")
    val nameEn: String
)
