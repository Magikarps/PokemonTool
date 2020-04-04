package com.example.pokemontool.ui.team

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.Team
import com.example.pokemontool.databinding.LayoutTeamItemBinding

class TeamListAdapter(val clickListener: TeamListListener) :
    ListAdapter<Team, TeamListAdapter.TeamViewHolder>(TeamListCallback()) {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTeamItemBinding.inflate(inflater, parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.backgroundBlue
                )
            )
        }
    }

    class TeamViewHolder constructor(val binding: LayoutTeamItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(team: Team, clickListener: TeamListListener) {
            binding.team = team
            binding.clickListener = clickListener
        }
    }
}

class TeamListCallback : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.teamId == newItem.teamId
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem == newItem
    }
}

class TeamListListener(val clickListener: (teamId: Long) -> Unit) {
    fun onClick(team: Team) = clickListener(team.teamId)
}