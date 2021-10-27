package com.example.vismatask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.data.db.AppDatabase
import com.example.vismatask.data.repository.AppRepository
import com.example.vismatask.databinding.InitialFragmentBinding
import com.example.vismatask.ui.adapters.CategoriesRvAdapter
import com.example.vismatask.ui.adapters.StorageTypesRvAdapter
import com.example.vismatask.viewmodels.InitialViewModel
import com.example.vismatask.viewmodels.InitialViewModelFactory

class InitialFragment : Fragment() {

    private lateinit var viewModel: InitialViewModel
    private lateinit var categoriesRvAdapter: CategoriesRvAdapter
    private lateinit var storageTypesRvAdapter: StorageTypesRvAdapter
    private lateinit var initialBinding: InitialFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initialBinding = InitialFragmentBinding.inflate(inflater, container, false)
        return initialBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appRepository = AppRepository(AppDatabase.getDatabase(requireContext()), AppDatabase.getInMemoryDatabase(requireContext()))
        val initialViewModelProviderFactory =
            activity?.let { InitialViewModelFactory(appRepository, it.application) }
        if (initialViewModelProviderFactory != null)
        {
            viewModel = ViewModelProvider(
                this,
                initialViewModelProviderFactory
            )[InitialViewModel::class.java]
        }

        viewModel.fetchSongs()

        viewModel.allInMemorySongs.observe(viewLifecycleOwner) { list ->
            categoriesRvAdapter = CategoriesRvAdapter(list, context)
            initialBinding.categoriesRecyclerView.adapter = categoriesRvAdapter

            storageTypesRvAdapter = StorageTypesRvAdapter(context, viewModel.getStorageTypesList())
            initialBinding.storageTypesRecyclerView.adapter = storageTypesRvAdapter
        }

        viewModel.allPersistentSongs.observe(viewLifecycleOwner) {
            storageTypesRvAdapter = StorageTypesRvAdapter(context, viewModel.getStorageTypesList())
            initialBinding.storageTypesRecyclerView.adapter = storageTypesRvAdapter
        }

        initialBinding.swipeSongsRefresh.setOnRefreshListener {
            viewModel.fetchSongs()
            initialBinding.swipeSongsRefresh.isRefreshing = false
        }
    }

}