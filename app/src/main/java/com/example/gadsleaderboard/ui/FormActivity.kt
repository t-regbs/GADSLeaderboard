package com.example.gadsleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.api.RetrofitBuilder
import com.example.gadsleaderboard.data.api.SubmitBuilder
import com.example.gadsleaderboard.databinding.ActivityFormBinding
import com.example.gadsleaderboard.databinding.DialogAlertPromptBinding
import com.example.gadsleaderboard.databinding.DialogResultEnteredBinding
import com.example.gadsleaderboard.ui.learningleaders.LearningLeadersViewModel
import com.example.gadsleaderboard.ui.learningleaders.LearningViewModelFactory
import com.example.gadsleaderboard.ui.submitform.FormViewModel
import com.example.gadsleaderboard.ui.submitform.FormViewModelFactory
import com.example.gadsleaderboard.utils.Status

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private lateinit var formViewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        setToolbar()
        setupViewModel()
        binding.viewModel = formViewModel
        binding.submitBtn.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_alert_prompt, null)
            val dialogBinding = DialogAlertPromptBinding.bind(dialogView)

            val builder: AlertDialog = AlertDialog.Builder(this).create()
            builder.setView(dialogView)
            builder.show()

            dialogBinding.button.setOnClickListener {
                builder.dismiss()
                setupObservers()
            }
        }
    }

    private fun setupObservers() {
        formViewModel.continueRequest().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        createResponseDialog(R.drawable.ic_baseline_check_circle_24, getString(R.string.submit_success))
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { leaders -> adapter.submitList(leaders) }
                    }
                    Status.ERROR -> {
//                        progressBar.visibility = View.GONE
                        createResponseDialog(R.drawable.ic_baseline_report_problem_24, getString(R.string.submit_error))
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        formViewModel = ViewModelProvider(
            this,
            FormViewModelFactory(ApiHelper(RetrofitBuilder.apiService, SubmitBuilder.submitService))
        ).get(FormViewModel::class.java)
    }

    private fun setToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun createResponseDialog(res: Int, text: String) {
        val dialog = layoutInflater.inflate(R.layout.dialog_result_entered, null)
        val binding = DialogResultEnteredBinding.bind(dialog)

        val builder: AlertDialog = AlertDialog.Builder(this).create()
        builder.setView(dialog)
        builder.show()

        binding.submissionResponse.text = text
        binding.img.setImageResource(res)
    }

}