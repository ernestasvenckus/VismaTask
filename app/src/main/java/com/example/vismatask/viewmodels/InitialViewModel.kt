package com.example.vismatask.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InitialViewModel(private val repository: AppRepository) : ViewModel() {
    val allInMemorySongs: LiveData<List<Song>> = repository.getInMemorySongs()
    val allPersistentSongs: LiveData<List<Song>> = repository.getPersistentSongs()

    fun fetchSongs()
    {
        val callback = object : Callback<List<Song>> {
            override fun onResponse(call: Call<List<Song>>, response: Response<List<Song>>) {
                if (response.isSuccessful) {
                    Log.i("fetchSongs", "SUCCESS!")
                    viewModelScope.launch(Dispatchers.IO) {
                        response.body()?.let {
                            repository.insertAllSongsToInMemoryDb(*it.toTypedArray())
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<Song>>, t: Throwable) {
                Log.i("fetchSongs", "FAILURE!")
            }
        }
        repository.fetchSongs(callback)
    }
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