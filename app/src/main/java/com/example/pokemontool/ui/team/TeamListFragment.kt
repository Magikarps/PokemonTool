package com.example.pokemontool.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.Team
import com.example.pokemontool.databinding.FragmentTeamListBinding
import com.example.pokemontool.network.DataManager
import com.google.android.material.snackbar.Snackbar

class TeamListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeamListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_team_list, container, false)
        val viewModel = TeamListViewModel()
        binding.model = viewModel
        binding.setLifecycleOwner(this)

        val adapter = TeamListAdapter(TeamListListener { teamId ->
            Toast.makeText(context, "$teamId clicked!", Toast.LENGTH_SHORT).show()
        })
        binding.teamList.adapter = adapter

        viewModel.teamList.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })

        return binding.root
    }

}
