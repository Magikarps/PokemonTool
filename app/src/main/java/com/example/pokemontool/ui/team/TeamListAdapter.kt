package com.example.pokemontool.ui.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.Team
import com.example.pokemontool.getFirst3Pokemon
import com.example.pokemontool.getLast3Pokemon

class TeamListAdapter(private var teamList: Array<Team>, private val context: Context) :
    RecyclerView.Adapter<TeamListAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        var context = parent.context
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_team_item, parent, false)
        return TeamViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList.get(position))
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,
                R.color.backgroundBlue
            ))
        }
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var teamName: TextView = view.findViewById(R.id.team_name)
        var party1: TextView = view.findViewById(R.id.party1)
        var party2: TextView = view.findViewById(R.id.party2)

        fun bind(team: Team) {
            teamName.text = team.teamName
            party1.text = getFirst3Pokemon(team)
            party2.text = getLast3Pokemon(team)
        }
    }
}