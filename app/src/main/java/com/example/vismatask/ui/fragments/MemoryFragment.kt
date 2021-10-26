package com.example.vismatask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.databinding.MemoryFragmentBinding
import com.example.vismatask.viewmodels.MemoryViewModel

class MemoryFragment : Fragment() {

    companion object {
        fun newInstance() = MemoryFragment()
    }

    private lateinit var viewModel: MemoryViewModel
    private lateinit var memoryBinding: MemoryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        memoryBinding = MemoryFragmentBinding.inflate(inflater, container, false)
        return memoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MemoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}