package com.example.pokemontool.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.model.History
import java.util.*

class HistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_history, container, false)
        recyclerView = view.findViewById(R.id.history_list)

        // TODO: dummy data
        var historyL: Array<History> = emptyArray()
        historyL += History(Date(), true, "Team 1", "Magikarp", "Magikarp", "Magikarp", "Magikarp", "Magikarp", "Magikarp")
        historyL += History(Date(), false, "Team 2", "Magikarp", "Magikarp", "Magikarp", "Magikarp", "Magikarp", "Magikarp")

        recyclerView.apply {
            adapter = HistoryAdapter(historyL, context)
        }

        return view
    }

}
