package com.example.vismatask.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vismatask.viewmodels.FilesystemViewModel
import com.example.vismatask.R
import com.example.vismatask.databinding.FilesystemFragmentBinding

class FilesystemFragment : Fragment() {

    companion object {
        fun newInstance() = FilesystemFragment()
    }

    private lateinit var viewModel: FilesystemViewModel
    private lateinit var filesystemBinding: FilesystemFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filesystemBinding = FilesystemFragmentBinding.inflate(inflater, container, false)
        return filesystemBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilesystemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}