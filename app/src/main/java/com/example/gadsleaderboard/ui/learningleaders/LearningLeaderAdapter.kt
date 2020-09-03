package com.example.gadsleaderboard.ui.learningleaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.databinding.LearningLeadersItemBinding
import com.example.gadsleaderboard.models.LearningLeader

class LearningLeaderAdapter : ListAdapter<LearningLeader, LearningLeaderAdapter.ViewHolder>(
    COMPARATOR
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val learningLeader = getItem(position)
        learningLeader?.let {
            holder.bind(it)
        }
    }


    class ViewHolder private constructor(val learningLeadersItemBinding: LearningLeadersItemBinding):
        RecyclerView.ViewHolder(learningLeadersItemBinding.root) {
        companion object{
            fun fromParent(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LearningLeadersItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }

        fun bind(learningLeader: LearningLeader){
            learningLeadersItemBinding.learningLeader = learningLeader
            learningLeadersItemBinding.executePendingBindings()
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<LearningLeader>() {
            override fun areItemsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean =
                oldItem == newItem
        }
    }

}