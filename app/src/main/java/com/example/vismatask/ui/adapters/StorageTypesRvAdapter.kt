package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.databinding.StorageTypeItemLayoutBinding

class StorageTypesRvAdapter(val context: Context?) : RecyclerView.Adapter<StorageTypesViewHolder>() {

    private val storageTypes = getStorageTypesList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageTypesViewHolder {
        return StorageTypesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.storage_type_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StorageTypesViewHolder, position: Int) {
        holder.storageTypeName.text = storageTypes[position]
    }

    override fun getItemCount(): Int {
        return storageTypes.size
    }

    private fun getStorageTypesList(): List<String>
    {
        val result: MutableList<String> = ArrayList()
        if (context != null) {
            result.add(context.getString(R.string.memory))
            result.add(context.getString(R.string.filesystem))
        }

        return result
    }
}

class StorageTypesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = StorageTypeItemLayoutBinding.bind(itemView)
    val storageTypeName = contentBinding.storageTypeName
    val storedSongsLength = contentBinding.storedSongsLength
}