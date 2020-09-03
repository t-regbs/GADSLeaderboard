package com.example.gadsleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.databinding.FragmentLearningLeadersBinding

class LearningLeadersFragment : Fragment() {

    private lateinit var binding: FragmentLearningLeadersBinding
    private var leadersViewModel: LearningLeadersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(this).get(LearningLeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningLeadersBinding.inflate(inflater, container, false)
        return binding.root
    }

}