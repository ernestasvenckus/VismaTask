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
import com.example.vismatask.databinding.MemoryFragmentBinding
import com.example.vismatask.ui.adapters.SongsRvAdapter
import com.example.vismatask.viewmodels.MemoryViewModel
import com.example.vismatask.viewmodels.MemoryViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoryFragment : Fragment() {

    private lateinit var viewModel: MemoryViewModel
    private lateinit var memoryBinding: MemoryFragmentBinding
    private lateinit var songsRvAdapter: SongsRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        memoryBinding = MemoryFragmentBinding.inflate(inflater, container, false)
        return memoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appRepository = AppRepository(AppDatabase.getDatabase(requireContext()), AppDatabase.getInMemoryDatabase(requireContext()))
        val memoryViewModelProviderFactory = MemoryViewModelFactory(appRepository)
        viewModel = ViewModelProvider(
            this,
            memoryViewModelProviderFactory
        )[MemoryViewModel::class.java]

        val delegate = object : SongsRvAdapter.SongsDelegate
        {
            override fun toggleSongSaveStatus(song: Song) {
                song.saved = !song.saved
                viewModel.viewModelScope.launch(Dispatchers.IO) {
                    appRepository.insertSongToInMemoryDb(song)
                }
            }
        }

        viewModel.allInMemorySongs.observe(viewLifecycleOwner) { list ->
            songsRvAdapter = SongsRvAdapter(list, context, delegate)
            memoryBinding.memorySongsRecyclerView.adapter = songsRvAdapter
        }
    }

}