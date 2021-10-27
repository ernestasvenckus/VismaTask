package com.example.vismatask.data.models

import androidx.lifecycle.LiveData

class StorageType(val name: String, val songs: LiveData<List<Song>>)