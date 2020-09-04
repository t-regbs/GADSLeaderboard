package com.example.gadsleaderboard.ui.skilliqleaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.api.RetrofitBuilder
import com.example.gadsleaderboard.data.api.SubmitBuilder
import com.example.gadsleaderboard.databinding.FragmentIqLeadersBinding
import com.example.gadsleaderboard.utils.Status

class IqLeadersFragment : Fragment() {

    private lateinit var binding: FragmentIqLeadersBinding
    private lateinit var leadersViewModel: IqLeadersViewModel
    private val adapter = IqLeaderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(
            this,
            IqViewModelFactory(ApiHelper(RetrofitBuilder.apiService, SubmitBuilder.submitService))
        ).get(IqLeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIqLeadersBinding.inflate(inflater, container, false).apply {
            iqLeadersRv.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        leadersViewModel.getIqLeaders().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.iqLeadersRv.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        resource.data?.let { leaders -> adapter.submitList(leaders) }
                    }
                    Status.ERROR -> {
                        binding.iqLeadersRv.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
                        binding.iqLeadersRv.visibility = View.GONE
                    }
                }
            }
        })
    }

}