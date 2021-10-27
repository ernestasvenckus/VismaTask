package com.example.vismatask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository

class MemoryViewModel(repository: AppRepository) : ViewModel() {
    val allInMemorySongs: LiveData<List<Song>> = repository.getInMemorySongs()
}

class MemoryViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}