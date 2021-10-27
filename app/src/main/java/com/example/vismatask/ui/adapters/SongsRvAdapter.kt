package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.SongSaveSimpleItemLayoutBinding
import com.example.vismatask.utils.SongUtils

class SongsRvAdapter(private val songs: List<Song>, val context: Context?, private val delegate: SongsDelegate) : RecyclerView.Adapter<SongsViewHolder>() {

    interface SongsDelegate
    {
        fun toggleSongSaveStatus(song: Song)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        return SongsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_save_simple_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.songTitle.text = songs[position].title
        holder.songInfo.text = SongUtils.getSongSizeAndLengthString(songs[position])

        if (context != null) {
            if (songs[position].saved) {
                holder.buttonSaveSong.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_check_24))
            }
            else {
                holder.buttonSaveSong.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_save_24))
            }

            holder.buttonSaveSong.setOnClickListener {
                if (songs[position].saved) {
                    holder.buttonSaveSong.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_save_24))
                }
                else {
                    holder.buttonSaveSong.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_check_24))
                }

                delegate.toggleSongSaveStatus(songs[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return songs.size
    }
}

class SongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongSaveSimpleItemLayoutBinding.bind(itemView)
    val songTitle = contentBinding.songLayout.songTitle
    val songInfo = contentBinding.songLayout.songInfo
    val buttonSaveSong = contentBinding.buttonSaveSong
}