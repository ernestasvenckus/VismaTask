package com.example.vismatask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository

class FilesystemViewModel(repository: AppRepository) : ViewModel() {
    val allPersistentSongs: LiveData<List<Song>> = repository.getPersistentSongs()
}

class FilesystemViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilesystemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilesystemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}