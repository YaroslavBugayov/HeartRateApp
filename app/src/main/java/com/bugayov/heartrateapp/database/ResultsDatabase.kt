package com.bugayov.heartrateapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ResultEntity::class], version = 1, exportSchema = false)
abstract class ResultsDatabase : RoomDatabase() {
    abstract fun resultDao(): ResultDao

    companion object {
        @Volatile
        private var INSTANCE: ResultsDatabase? = null

        fun getDatabase(context: Context): ResultsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ResultsDatabase::class.java,
                    "results_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}