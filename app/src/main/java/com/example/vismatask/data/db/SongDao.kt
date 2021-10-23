package com.example.vismatask.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.vismatask.data.models.Song

@Dao
interface SongDao {

    @Query("SELECT * FROM Song ORDER BY id ASC")
    fun getAll(): LiveData<List<Song>>

    @Query("SELECT * FROM Song WHERE genre = :genre")
    fun findByGenre(genre: String): LiveData<List<Song>>

    @Insert
    fun insertAll(vararg songs: Song)

    @Delete
    fun delete(song: Song)
}