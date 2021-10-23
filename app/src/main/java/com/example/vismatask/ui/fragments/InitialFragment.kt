package com.example.vismatask.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vismatask.R
import com.example.vismatask.databinding.InitialFragmentBinding
import com.example.vismatask.viewmodels.InitialViewModel

class InitialFragment : Fragment() {

    companion object {
        fun newInstance() = InitialFragment()
    }

    private lateinit var viewModel: InitialViewModel
    private lateinit var initialBinding: InitialFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initialBinding = InitialFragmentBinding.inflate(inflater, container, false)
        return initialBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(InitialViewModel::class.java)
        // TODO: Use the ViewModel
    }

}