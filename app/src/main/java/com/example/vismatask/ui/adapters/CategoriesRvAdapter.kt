package com.example.vismatask.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.CategoryItemLayoutBinding

class CategoriesRvAdapter(allSongs: List<Song>) : RecyclerView.Adapter<CategoriesViewHolder>() {

    val allSongs = allSongs
    val categories = getCategories(allSongs)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.categoryName.text = categories.get(position)
        val categorySongsRvAdapter = CategorySongsRvAdapter(getSongsByCategory(categories.get(position)))
        holder.categorySongsRecyclerView.adapter = categorySongsRvAdapter
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun getCategories(songs: List<Song>): List<String>
    {
        val result: MutableList<String> = ArrayList();

        for (song in songs)
        {
            if (!result.contains(song.genre))
            {
                result.add(song.genre)
            }
        }

        return result
    }

    private fun getSongsByCategory(category: String): List<Song>
    {
        val result: MutableList<Song> = ArrayList()

        for (song in allSongs)
        {
            if (song.genre.equals(category))
            {
                result.add(song)
            }
        }

        return result
    }
}

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = CategoryItemLayoutBinding.bind(itemView)
    val categoryName = contentBinding.categoryItemName
    val buttonSeeAll = contentBinding.buttonSeeAll
    val categorySongsRecyclerView = contentBinding.categorySongsRecyclerView
}