package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.SongSimpleItemLayoutBinding

class CategorySongsSimpleRvAdapter(private val songs: List<Song>, val context: Context?) : RecyclerView.Adapter<CategorySongsSimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySongsSimpleViewHolder {
        return CategorySongsSimpleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_simple_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategorySongsSimpleViewHolder, position: Int) {
        holder.songTitle.text = songs[position].title
    }

    override fun getItemCount(): Int {
        return songs.size
    }

}

class CategorySongsSimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongSimpleItemLayoutBinding.bind(itemView)
    val songTitle = contentBinding.songTitle
    val songInfo = contentBinding.songInfo
}