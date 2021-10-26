package com.example.vismatask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository

class CategoryViewModel(repository: AppRepository, category: String) : ViewModel() {
    val categorySongs: LiveData<List<Song>> = repository.findInMemorySongsByGenre(category)
}

class CategoryViewModelFactory(private val repository: AppRepository, private val category: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(repository, category) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}