package com.example.gadsleaderboard.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gadsleaderboard.ui.skilliqleaders.IqLeadersFragment
import com.example.gadsleaderboard.ui.learningleaders.LearningLeadersFragment

val titles = arrayOf("Learning Leaders", "Skill IQ Leaders")
class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return LearningLeadersFragment()
            1 -> return IqLeadersFragment()
        }
        return LearningLeadersFragment()
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}