package com.example.vismatask.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.databinding.SongItemLayoutBinding

class CategorySongsRvAdapter : RecyclerView.Adapter<CategorySongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySongsViewHolder {
        return CategorySongsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategorySongsViewHolder, position: Int) {
        Log.e("CategorySongsRv", position.toString())
    }

    override fun getItemCount(): Int {
        return 5
    }

}

class CategorySongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongItemLayoutBinding.bind(itemView)
    val songImage = contentBinding.songImage
    val songTitle = contentBinding.songTitle
    val songSize = contentBinding.songSize
    val songLength = contentBinding.songLength
}