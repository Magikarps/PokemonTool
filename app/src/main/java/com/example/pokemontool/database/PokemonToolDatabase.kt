package com.example.pokemontool.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonToolDatabase : RoomDatabase() {

    abstract val pokemonDao: PokemonDao

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
                        .addCallback(PokemonDatabaseCallback(context))
                        .build()
                    INSTANCE = instance
                }
                return INSTANCE!!
            }
        }
    }

    private class PokemonDatabaseCallback(val context: Context) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(database.pokemonDao)
                }
            }
        }

        fun populateDatabase(dao: PokemonDao) {
            val inputStream = context.resources.assets.open("PokemonData.csv")
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            var line = bufferedReader.readLine()
            while (line != null) {
                val data = line.split(",")
                val pokemon = Pokemon(data[0], data[1], data[2])
                dao.insert(pokemon)
                line = bufferedReader.readLine()
            }

        }
    }
}