package com.example.pokemontool.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoryDao {

    @Insert
    fun insert(history: History)

    @Update
    fun update(history: History)

    @Query("SELECT * FROM history WHERE historyId = :key")
    fun get(key: Long): History

    @Query("SELECT * FROM history")
    fun getAll(): LiveData<List<History>>

    @Query("DELETE FROM history WHERE historyId = :key")
    fun delete(key: Long)
}