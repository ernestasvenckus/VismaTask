package com.example.vismatask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository

class InitialViewModel(private val repository: AppRepository) : ViewModel() {
    val allSongs: LiveData<List<Song>> = repository.getPersistentSongs()


}

class InitialViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InitialViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InitialViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}