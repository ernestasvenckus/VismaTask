package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.models.StorageType
import com.example.vismatask.databinding.StorageTypeItemLayoutBinding
import com.example.vismatask.ui.fragments.InitialFragmentDirections
import com.example.vismatask.utils.SongUtils

class StorageTypesRvAdapter(val context: Context?, private val storageTypes: List<StorageType>) : RecyclerView.Adapter<StorageTypesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageTypesViewHolder {
        return StorageTypesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.storage_type_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StorageTypesViewHolder, position: Int) {
        holder.storageTypeName.text = storageTypes[position].name
        if (storageTypes[position].songs.value != null) {
            holder.storedSongsLength.text = getSavedSongsLengthString(storageTypes[position].songs.value!!)
        }

        holder.itemView.setOnClickListener {

            var action: NavDirections? = null

            if (context != null) {
                if (storageTypes[position].name == context.getString(R.string.filesystem)) {
                    action = InitialFragmentDirections.actionInitialFragmentToFilesystemFragment()
                }
                else if (storageTypes[position].name == context.getString(R.string.memory)) {
                    action = InitialFragmentDirections.actionInitialFragmentToMemoryFragment()
                }
            }
            if (action != null) {
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return storageTypes.size
    }

    private fun getSavedSongsLengthString(songs: List<Song>): String {
        var songsLength: Long = 0
        for (song in songs)
        {
            if (song.saved)
            {
                songsLength += song.lengthSeconds
            }
        }

        return SongUtils.formatSongLengthToString(songsLength)
    }
}

class StorageTypesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = StorageTypeItemLayoutBinding.bind(itemView)
    val storageTypeName = contentBinding.storageTypeName
    val storedSongsLength = contentBinding.storedSongsLength
}