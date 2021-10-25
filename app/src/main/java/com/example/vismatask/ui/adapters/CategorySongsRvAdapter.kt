package com.example.vismatask.ui.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.SongItemLayoutBinding

class CategorySongsRvAdapter(songs: List<Song>) : RecyclerView.Adapter<CategorySongsViewHolder>() {

    val songs = songs

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySongsViewHolder {
        return CategorySongsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategorySongsViewHolder, position: Int) {
        holder.songTitle.text = songs.get(position).title
        holder.songSize.text = songs.get(position).sizeKB
        holder.songLength.text = songs.get(position).lengthSeconds.toString()
        /*Glide.with(holder.itemView)
            .load(Uri.parse(songs[position].imageUrl))
            .centerCrop()
            .into(holder.songImage)*/
        //holder.songImage.setImageURI(Uri.parse(songs.get(position).imageUrl))
    }

    override fun getItemCount(): Int {
        return if (songs.size > MAX_NUMBER_OF_SONGS) MAX_NUMBER_OF_SONGS else songs.size
    }

    companion object {
        const val MAX_NUMBER_OF_SONGS = 5;
    }
}

class CategorySongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongItemLayoutBinding.bind(itemView)
    val songImage = contentBinding.songImage
    val songTitle = contentBinding.songTitle
    val songSize = contentBinding.songSize
    val songLength = contentBinding.songLength
}