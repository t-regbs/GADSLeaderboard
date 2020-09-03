package com.example.gadsleaderboard.ui.skilliqleaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.databinding.IqLeadersItemBinding
import com.example.gadsleaderboard.models.IqLeader

class IqLeaderAdapter : ListAdapter<IqLeader, IqLeaderAdapter.ViewHolder>(COMPARATOR){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val iqLeader = getItem(position)
        iqLeader?.let {
            holder.bind(it)
        }
    }


    class ViewHolder private constructor(val iqLeadersItemBinding: IqLeadersItemBinding):
        RecyclerView.ViewHolder(iqLeadersItemBinding.root) {
        companion object{
            fun fromParent(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = IqLeadersItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }

        fun bind(iqLeader: IqLeader){
            iqLeadersItemBinding.skillIQLeader = iqLeader
            iqLeadersItemBinding.executePendingBindings()
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<IqLeader>() {
            override fun areItemsTheSame(oldItem: IqLeader, newItem: IqLeader): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: IqLeader, newItem: IqLeader): Boolean =
                oldItem == newItem
        }
    }

}