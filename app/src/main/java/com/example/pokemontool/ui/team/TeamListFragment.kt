package com.example.pokemontool.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.Team

class TeamListFragment : Fragment() {
    private lateinit var teamRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_team_list, container, false)
        teamRecyclerView = view.findViewById(R.id.team_list)

        // TODO: dummy data
        var teamL: Array<Team> = emptyArray()
        teamL += Team(
            0L,
            "Team 1",
            "Magikarp",
            "Magikarp",
            "Magikarp",
            "Magikarp",
            "Magikarp",
            "Magikarp"
        )
        teamL += Team(
            0L,
            "Team 2",
            "Pikachu",
            "Pikachu",
            "Pikachu",
            "Pikachu",
            "Pikachu",
            "Pikachu"
        )

        teamRecyclerView.apply { adapter =
            TeamListAdapter(teamL, context)
        }
//        teamRecyclerView.adapter = TeamListAdapter(teamL)

        return view
    }

}
