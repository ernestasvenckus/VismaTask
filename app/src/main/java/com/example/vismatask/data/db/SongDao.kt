package com.example.vismatask.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.vismatask.data.models.Song

@Dao
interface SongDao {

    @Query("SELECT * FROM Song ORDER BY id ASC")
    fun getAll(): LiveData<List<Song>>

    @Query("SELECT * FROM Song WHERE genre = :genre")
    fun findByGenre(genre: String): LiveData<List<Song>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(song: Song)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg songs: Song)

    @Delete
    suspend fun delete(song: Song)
}