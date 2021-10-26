package com.example.vismatask.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vismatask.data.models.Song

@Database(entities = [Song::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao

    companion object {
        private const val DATABASE_NAME = "app_database"
        @Volatile
        private var INSTANCE: AppDatabase? = null
        @Volatile
        private var IN_MEMORY_INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        fun getInMemoryDatabase(context: Context): AppDatabase {
            return IN_MEMORY_INSTANCE ?: synchronized(this) {
                val instance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java
                ).build()
                IN_MEMORY_INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}