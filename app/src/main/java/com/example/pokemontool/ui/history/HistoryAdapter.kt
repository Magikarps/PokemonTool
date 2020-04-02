package com.example.pokemontool.ui.history

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.History
import com.example.pokemontool.getFirst3Pokemon
import com.example.pokemontool.getLast3Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class HistoryAdapter(val clickListener: HistoryListner) :
    ListAdapter<History, HistoryAdapter.HistoryViewHolder>(HistoryCallBack()) {
    lateinit var context: Context

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.layout_history_item, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(context, R.color.backgroundBlue)
            )
        }
    }

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var date: TextView = view.findViewById(R.id.battle_date)
        var result: ImageView = view.findViewById(R.id.result)
        var team: TextView = view.findViewById(R.id.team_name)
        var opponentPokemon1: TextView = view.findViewById(R.id.op_party1)
        var opponentPokemon2: TextView = view.findViewById(R.id.op_party2)

        fun bind(history: History, clickListener: HistoryListner) {
            date.text = history.date.toString()
            result.setBackgroundResource(if (history.win) R.drawable.win else R.drawable.lose)
            team.text = history.team
            opponentPokemon1.text = getFirst3Pokemon(history)
            opponentPokemon2.text = getLast3Pokemon(history)
        }
    }
}

class HistoryCallBack : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem.historyId == newItem.historyId
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem == newItem
    }
}

// TODO: Research
class HistoryListner(val clickListener: (hId: Long) ->Unit ) {
    fun onClick(history: History) = clickListener(history.historyId)
}
