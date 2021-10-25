package com.example.vismatask.data.rest

import com.example.vismatask.data.models.Song
import retrofit2.Call
import retrofit2.http.GET

interface SongsService {
    @GET("/songs")
    fun getSongs(): Call<List<Song>>
}