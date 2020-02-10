package com.example.pokemontool.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.model.History

class HistoryAdapter(private var historyList: Array<History>, private val context: Context) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        var context = parent.context
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_history_item, parent, false)
        return HistoryViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList.get(position))
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,
                R.color.backgroundBlue
            ))
        }
    }

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var date: TextView = view.findViewById(R.id.battle_date)
        var result: ImageView = view.findViewById(R.id.result)
        var team: TextView = view.findViewById(R.id.team_name)
        var opponentPokemon1: TextView = view.findViewById(R.id.op_party1)
        var opponentPokemon2: TextView = view.findViewById(R.id.op_party2)

        fun bind(history: History) {
            date.text = history.date.toString()
            result.setBackgroundResource(if (history.win) R.drawable.win else R.drawable.lose)
            team.text = history.team
            opponentPokemon1.text = history.getFirst3Pokemon()
            opponentPokemon2.text = history.getLast3Pokemon()
        }
    }
}