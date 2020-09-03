package com.example.gadsleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.gadsleaderboard.LearningLeaderAdapter
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.api.RetrofitBuilder
import com.example.gadsleaderboard.databinding.FragmentLearningLeadersBinding
import com.example.gadsleaderboard.utils.Status

class LearningLeadersFragment : Fragment() {

    private lateinit var binding: FragmentLearningLeadersBinding
    private lateinit var leadersViewModel: LearningLeadersViewModel
    private val adapter = LearningLeaderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(
            this,
            LearningViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(LearningLeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningLeadersBinding.inflate(inflater, container, false).apply {
            learningLeadersRv.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        leadersViewModel.getLearningLeaders().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.learningLeadersRv.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        resource.data?.let { leaders -> adapter.submitList(leaders) }
                    }
                    Status.ERROR -> {
                        binding.learningLeadersRv.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
                        binding.learningLeadersRv.visibility = View.GONE
                    }
                }
            }
        })
    }


}