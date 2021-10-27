package com.example.vismatask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.databinding.CategoryItemLayoutBinding
import com.example.vismatask.ui.fragments.InitialFragmentDirections

class CategoriesRvAdapter(private val allSongs: List<Song>, val context: Context?) : RecyclerView.Adapter<CategoriesViewHolder>() {

    private val categories = getCategories(allSongs)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.categoryName.text = categories[position]

        val songs = getSongsByCategory(categories[position])

        val categorySongsRvAdapter = CategorySongsRvAdapter(songs, context)

        holder.buttonSeeAll.setOnClickListener {
            val action = InitialFragmentDirections.actionInitialFragmentToCategoryFragment(categories[position])
            Navigation.findNavController(it).navigate(action)
        }

        holder.categorySongsRecyclerView.adapter = categorySongsRvAdapter
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun getCategories(songs: List<Song>): List<String>
    {
        val result: MutableList<String> = ArrayList()

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
            if (song.genre == category)
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