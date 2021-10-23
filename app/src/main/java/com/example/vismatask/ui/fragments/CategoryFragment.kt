package com.example.vismatask.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vismatask.viewmodels.CategoryViewModel
import com.example.vismatask.R
import com.example.vismatask.databinding.CategoryFragmentBinding

class CategoryFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private lateinit var viewModel: CategoryViewModel
    private lateinit var categoryBinding: CategoryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryBinding = CategoryFragmentBinding.inflate(inflater, container, false)
        return categoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}