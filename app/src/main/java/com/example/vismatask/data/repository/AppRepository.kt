package com.example.vismatask.data.repository

import com.example.vismatask.data.db.AppDatabase
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.rest.ServiceBuilder
import com.example.vismatask.data.rest.SongsService
import retrofit2.Callback

class AppRepository(
    private val persistentDatabase: AppDatabase,
    private val inMemoryDatabase: AppDatabase
) {
    fun getPersistentSongs() =
        persistentDatabase.songDao().getAll()

    fun findPersistentSongsByGenre(genre: String) =
        persistentDatabase.songDao().findByGenre(genre)

    suspend fun insertSongToPersistentDb(song: Song) =
        persistentDatabase.songDao().insert(song)

    suspend fun insertAllSongsToPersistentDb(vararg songs: Song) =
        persistentDatabase.songDao().insertAll(*songs)

    suspend fun deletePersistentSong(song: Song) =
        persistentDatabase.songDao().delete(song)

    fun getInMemorySongs() =
        inMemoryDatabase.songDao().getAll()

    fun findInMemorySongsByGenre(genre: String) =
        inMemoryDatabase.songDao().findByGenre(genre)

    suspend fun insertSongToInMemoryDb(song: Song) =
        inMemoryDatabase.songDao().insert(song)

    suspend fun insertAllSongsToInMemoryDb(vararg songs: Song) =
        inMemoryDatabase.songDao().insertAll(*songs)

    suspend fun deleteInMemorySong(song: Song) =
        inMemoryDatabase.songDao().delete(song)

    fun fetchSongs(callback: Callback<List<Song>>)
    {
        val service = ServiceBuilder.buildService(SongsService::class.java)
        val call = service.getSongs()
        call.enqueue(callback)
    }
}