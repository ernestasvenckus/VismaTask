package com.example.vismatask.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vismatask.viewmodels.MemoryViewModel
import com.example.vismatask.R

class MemoryFragment : Fragment() {

    companion object {
        fun newInstance() = MemoryFragment()
    }

    private lateinit var viewModel: MemoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.memory_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MemoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}