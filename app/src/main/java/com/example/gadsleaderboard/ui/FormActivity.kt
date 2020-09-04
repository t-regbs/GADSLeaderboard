package com.example.gadsleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.databinding.ActivityFormBinding
import com.example.gadsleaderboard.databinding.DialogResultEnteredBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        setToolbar()
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