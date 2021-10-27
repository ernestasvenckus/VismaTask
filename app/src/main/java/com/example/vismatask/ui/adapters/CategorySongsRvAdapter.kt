package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.SongItemLayoutBinding
import com.example.vismatask.utils.SongUtils

class CategorySongsRvAdapter(private val songs: List<Song>, val context: Context?) : RecyclerView.Adapter<CategorySongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySongsViewHolder {
        return CategorySongsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategorySongsViewHolder, position: Int) {
        holder.songTitle.text = songs[position].title
        holder.songSize.text = SongUtils.formatSongSizeToMegabytesString(songs[position].sizeKB)
        holder.songLength.text = SongUtils.formatSongLengthToString(songs[position].lengthSeconds)
        context?.let {
            Glide.with(it)
                .load(songs[position].imageUrl)
                .centerCrop()
                .signature(ObjectKey(songs[position].title + position))
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(holder.songImage)
        }
    }

    override fun getItemCount(): Int {
        return if (songs.size > MAX_NUMBER_OF_SONGS) MAX_NUMBER_OF_SONGS else songs.size
    }

    companion object {
        const val MAX_NUMBER_OF_SONGS = 5
    }
}

class CategorySongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongItemLayoutBinding.bind(itemView)
    val songImage = contentBinding.songImage
    val songTitle = contentBinding.songTitle
    val songSize = contentBinding.songSize
    val songLength = contentBinding.songLength
}