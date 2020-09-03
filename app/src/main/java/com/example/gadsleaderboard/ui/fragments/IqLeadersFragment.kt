package com.example.gadsleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.databinding.FragmentIqLeadersBinding

class IqLeadersFragment : Fragment() {

    private lateinit var binding: FragmentIqLeadersBinding
    private var leadersViewModel: IqLeadersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(this).get(IqLeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIqLeadersBinding.inflate(inflater, container, false)
        return binding.root
    }

}