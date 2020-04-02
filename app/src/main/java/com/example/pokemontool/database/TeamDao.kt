package com.example.pokemontool.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TeamDao {

    @Insert
    fun insert(team: Team)

    @Update
    fun update(team: Team)

    @Query("SELECT * FROM team WHERE teamId = :key")
    fun get(key: Long): Team

    @Query("SELECT * FROM team")
    fun getAll(): LiveData<List<Team>>

    @Query("DELETE FROM team WHERE teamId = :key")
    fun delete(key: Long)
}