package com.example.pokemontool.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {

    @Insert
    fun insert(pokemon: Pokemon)

    @Update
    fun update(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon WHERE pokemonId = :key")
    fun get(key: String): Pokemon

    @Query("SELECT * FROM pokemon")
    fun getAll(): List<Pokemon>

//    @Query("SELECT * FROM pokemon WHERE name_jp = :name")
//    fun getPokemonByNameJp(name: String): List<Pokemon>
//
//    @Query("SELECT * FROM pokemon WHERE name_en = :name")
//    fun getPokemonByNameEn(name: String): List<Pokemon>
}
