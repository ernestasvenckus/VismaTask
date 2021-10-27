package com.example.vismatask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vismatask.data.db.AppDatabase
import com.example.vismatask.data.models.Song
import com.example.vismatask.data.repository.AppRepository
import com.example.vismatask.databinding.FilesystemFragmentBinding
import com.example.vismatask.ui.adapters.SongsRvAdapter
import com.example.vismatask.viewmodels.FilesystemViewModel
import com.example.vismatask.viewmodels.FilesystemViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilesystemFragment : Fragment() {

    private lateinit var viewModel: FilesystemViewModel
    private lateinit var filesystemBinding: FilesystemFragmentBinding
    private lateinit var songsRvAdapter: SongsRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        filesystemBinding = FilesystemFragmentBinding.inflate(inflater, container, false)
        return filesystemBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appRepository = AppRepository(AppDatabase.getDatabase(requireContext()), AppDatabase.getInMemoryDatabase(requireContext()))
        val filesystemViewModelProviderFactory = FilesystemViewModelFactory(appRepository)
        viewModel = ViewModelProvider(
            this,
            filesystemViewModelProviderFactory
        )[FilesystemViewModel::class.java]

        val delegate = object : SongsRvAdapter.SongsDelegate
        {
            override fun toggleSongSaveStatus(song: Song) {
                song.saved = !song.saved
                viewModel.viewModelScope.launch(Dispatchers.IO) {
                    appRepository.insertSongToPersistentDb(song)
                }
            }
        }

        viewModel.allPersistentSongs.observe(viewLifecycleOwner) { list ->
            songsRvAdapter = SongsRvAdapter(list, context, delegate)
            filesystemBinding.filesystemSongsRecyclerView.adapter = songsRvAdapter
        }
    }

}