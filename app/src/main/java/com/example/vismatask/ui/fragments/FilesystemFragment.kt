package com.example.vismatask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vismatask.databinding.FilesystemFragmentBinding
import com.example.vismatask.viewmodels.FilesystemViewModel

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