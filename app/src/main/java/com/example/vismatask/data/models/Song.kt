package com.example.vismatask.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val sizeKB: Long = -1,
    val imageUrl: String,
    val lengthSeconds: Long = -1,
    val genre: String,
    var saved: Boolean
) : Serializable