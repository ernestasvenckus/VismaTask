package com.example.vismatask.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.vismatask.R
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.models.StorageType
import com.example.vismatask.data.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InitialViewModel(private val repository: AppRepository, application: Application) : AndroidViewModel(
    application
) {
    val allInMemorySongs: LiveData<List<Song>> = repository.getInMemorySongs()
    val allPersistentSongs: LiveData<List<Song>> = repository.getPersistentSongs()

    fun fetchSongs()
    {
        val callback = object : Callback<List<Song>> {
            override fun onResponse(call: Call<List<Song>>, response: Response<List<Song>>) {
                if (response.isSuccessful) {
                    viewModelScope.launch(Dispatchers.IO) {
                        response.body()?.let {
                            repository.insertAllSongsToInMemoryDb(*it.toTypedArray())
                            repository.insertAllSongsToPersistentDb(*it.toTypedArray())
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

    fun getStorageTypesList(): List<StorageType>
    {
        val result: MutableList<StorageType> = ArrayList()
        result.add(StorageType(getApplication<Application>().getString(R.string.memory), allInMemorySongs))
        result.add(StorageType(getApplication<Application>().getString(R.string.filesystem), allPersistentSongs))

        return result
    }
}

class InitialViewModelFactory(private val repository: AppRepository, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InitialViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InitialViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}