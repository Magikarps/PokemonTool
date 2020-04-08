package com.example.pokemontool.ui.team

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pokemontool.Mode
import com.example.pokemontool.R
import com.example.pokemontool.database.PokemonToolDatabase
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
        val dataSource = PokemonToolDatabase.getInstance(requireActivity().application).pokemonDao
        val viewModelFactory = TeamDetailViewModelFactory(mode, teamId, dataSource)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(TeamDetailViewModel::class.java)
        binding.viewModel = viewModel

        binding.editButton.setOnClickListener {
            viewModel.onClickEdit()
        }
        binding.doneButton.setOnClickListener {
            viewModel.onClickDone()
        }
        viewModel.navigateToEditMode.observe(viewLifecycleOwner, Observer {
            val bundle = bundleOf("mode" to Mode.EDIT, "teamId" to viewModel.team.value?.teamId)
            this.findNavController().navigate(R.id.action_teamDetailFragment_self, bundle)
        })
        viewModel.navigateToTeamList.observe(viewLifecycleOwner, Observer {
            this.findNavController().navigate(R.id.action_teamDetailFragment_to_teamListFragment)
        })

        // AutoCompleteTextView
        viewModel.allPokemon.observe(viewLifecycleOwner, Observer {
            val adapter = PokemonAdapter(
                requireContext(),
                R.layout.layout_pokemon_list_item,
                viewModel.allPokemon.value!!
            )

            binding.pokemon1.setAdapter(adapter)
            binding.pokemon1.threshold = 1
            // validator
            binding.pokemon1InputLayout.setAutoCompValidator(true)

        })
        viewModel.message.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        // Validation
        binding.teamInputLayout.setEditTextValidator()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
