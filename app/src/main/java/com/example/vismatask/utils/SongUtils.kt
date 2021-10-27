package com.example.vismatask.utils

import com.example.vismatask.data.models.Song
import java.util.*

object SongUtils {

    fun formatSongLengthToString(songLengthInSeconds: Long): String {
        val seconds: Long = songLengthInSeconds % 60
        val minutes: Long = (songLengthInSeconds / 60) % 60
        val hours: Long = songLengthInSeconds / (60L * 60L)

        return if (hours > 0) {
            String.format(Locale.getDefault(), "%dh %dm %ds", hours, minutes, seconds)
        } else {
            String.format(Locale.getDefault(), "%dm %ds", minutes, seconds)
        }
    }

    fun formatSongSizeToMegabytesString(songSizeInKB: Long): String {
        val songSizeInMB: Double = songSizeInKB.toDouble() / 1024
        return String.format(Locale.getDefault(), "%.2fMB", songSizeInMB)
    }

    fun getSongSizeAndLengthString(song: Song): String
    {
        val songSize = formatSongSizeToMegabytesString(song.sizeKB)
        val songLength = formatSongLengthToString(song.lengthSeconds)
        return "$songSize - $songLength"
    }
}