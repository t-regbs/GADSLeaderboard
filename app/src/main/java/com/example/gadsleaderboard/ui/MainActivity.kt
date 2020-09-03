package com.example.gadsleaderboard.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.utils.ViewPagerFragmentAdapter
import com.example.gadsleaderboard.databinding.ActivityMainBinding
import com.example.gadsleaderboard.utils.titles
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        binding.submitButton.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

    private fun init() {
        // removing toolbar elevation
        binding.topAppBar.elevation = 0f

        binding.viewPager.adapter = ViewPagerFragmentAdapter(this)

        // attaching tab mediator
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int -> tab.text = titles[position] }.attach()
    }
}