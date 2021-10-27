package com.example.vismatask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.vismatask.data.db.AppDatabase
import com.example.vismatask.data.repository.AppRepository
import com.example.vismatask.databinding.CategoryFragmentBinding
import com.example.vismatask.ui.adapters.CategorySongsSimpleRvAdapter
import com.example.vismatask.viewmodels.CategoryViewModel
import com.example.vismatask.viewmodels.CategoryViewModelFactory

class CategoryFragment : Fragment() {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var categoryBinding: CategoryFragmentBinding
    private lateinit var categoryRvAdapter: CategorySongsSimpleRvAdapter
    private val args: CategoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        categoryBinding = CategoryFragmentBinding.inflate(inflater, container, false)
        return categoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appRepository = AppRepository(AppDatabase.getDatabase(requireContext()), AppDatabase.getInMemoryDatabase(requireContext()))
        val categoryViewModelProviderFactory = CategoryViewModelFactory(appRepository, args.category)
        viewModel = ViewModelProvider(
            this,
            categoryViewModelProviderFactory
        )[CategoryViewModel::class.java]

        categoryBinding.categoryName.text = args.category

        viewModel.categorySongs.observe(viewLifecycleOwner) { list ->
            categoryRvAdapter = CategorySongsSimpleRvAdapter(list, context)
            categoryBinding.categorySongsRecyclerView.adapter = categoryRvAdapter
        }
    }

}