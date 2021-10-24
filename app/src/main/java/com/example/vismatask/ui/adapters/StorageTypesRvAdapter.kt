package com.example.vismatask.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.databinding.StorageTypeItemLayoutBinding

class StorageTypesRvAdapter : RecyclerView.Adapter<StorageTypesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageTypesViewHolder {
        return StorageTypesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.storage_type_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StorageTypesViewHolder, position: Int) {
        Log.e("StorageTypesRv", position.toString())
    }

    override fun getItemCount(): Int {
        return 2
    }

}

class StorageTypesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = StorageTypeItemLayoutBinding.bind(itemView)
    val storageTypeName = contentBinding.storageTypeName
    val storedSongsLength = contentBinding.storedSongsLength
}