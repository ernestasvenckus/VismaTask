package com.example.vismatask.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vismatask.R
import com.example.vismatask.databinding.CategoryItemLayoutBinding

class CategoriesRvAdapter : RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        Log.e("CategoriesRv", position.toString())
        val categorySongsRvAdapter = CategorySongsRvAdapter()
        holder.categorySongsRecyclerView.adapter = categorySongsRvAdapter
    }

    override fun getItemCount(): Int {
        return 10
    }

}

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val contentBinding = CategoryItemLayoutBinding.bind(itemView)
    val categoryName = contentBinding.categoryItemName
    val buttonSeeAll = contentBinding.buttonSeeAll
    val categorySongsRecyclerView = contentBinding.categorySongsRecyclerView
}