package com.example.vismatask.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vismatask.viewmodels.FilesystemViewModel
import com.example.vismatask.R

class FilesystemFragment : Fragment() {

    companion object {
        fun newInstance() = FilesystemFragment()
    }

    private lateinit var viewModel: FilesystemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filesystem_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilesystemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}