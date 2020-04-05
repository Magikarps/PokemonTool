package com.example.pokemontool.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pokemontool.Mode
import com.example.pokemontool.R
import com.example.pokemontool.databinding.FragmentTeamListBinding

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
            viewModel.onTeamClicked(teamId)
        })
        binding.teamList.adapter = adapter

        viewModel.teamList.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })
        viewModel.navigateToTeamDetail.observe(viewLifecycleOwner, Observer { teamId ->
            teamId?.let {
                val bundle = bundleOf("mode" to Mode.EDIT, "teamId" to teamId)
                this.findNavController().navigate(R.id.action_teamListFragment_to_teamDetailFragment, bundle)
            }
        })
        binding.addButton.setOnClickListener {
            val bundle = bundleOf("mode" to Mode.ADD)
            this.findNavController().navigate(R.id.action_teamListFragment_to_teamDetailFragment, bundle)
        }

        return binding.root
    }

}
