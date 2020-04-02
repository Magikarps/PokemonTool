package com.example.pokemontool.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class PokemonToolDatabase : RoomDatabase() {

    abstract val historyDao: HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonToolDatabase? = null

        fun getInstance(context: Context): PokemonToolDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PokemonToolDatabase::class.java,
                        "pokemon_tool_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}