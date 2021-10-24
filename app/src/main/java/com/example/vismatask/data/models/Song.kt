package com.example.vismatask.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val sizeKB: String,
    val imageUrl: String,
    val lengthSeconds: Int = -1,
    val genre: String,
    val saved: Boolean
)