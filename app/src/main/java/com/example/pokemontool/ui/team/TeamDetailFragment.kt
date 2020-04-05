package com.example.pokemontool.ui.team

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokemontool.Mode
import com.example.pokemontool.R
import com.example.pokemontool.databinding.FragmentTeamDetailBinding

class TeamDetailFragment : Fragment() {
    var teamId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mode = arguments?.get("mode") as Mode

        @Suppress("NON_EXHAUSTIVE_WHEN")
        if (Mode.REFERENCE == mode || Mode.EDIT == mode) {
            teamId = arguments?.getLong("teamId")
        }

        val binding: FragmentTeamDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_team_detail, container, false)
        val viewModelFactory = TeamDetailViewModelFactory(mode, teamId)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(TeamDetailViewModel::class.java)
        binding.team = viewModel.team
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
