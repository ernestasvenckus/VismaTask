package com.example.vismatask.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.databinding.SongSaveSimpleItemLayoutBinding

class SongsRvAdapter : RecyclerView.Adapter<SongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        return SongsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.song_save_simple_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        Log.e("SongsRv", position.toString())
    }

    override fun getItemCount(): Int {
        return 10
    }

}

class SongsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = SongSaveSimpleItemLayoutBinding.bind(itemView)
    val songTitle = contentBinding.songLayout.songTitle
    val songInfo = contentBinding.songLayout.songInfo
    val buttonSaveSong = contentBinding.buttonSaveSong
}