package com.example.pokemontool.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemontool.R
import com.example.pokemontool.database.PokemonToolDatabase
import com.example.pokemontool.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHistoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = HistoryViewModelFactory(application)
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(HistoryViewModel::class.java)

        binding.model = viewModel
        binding.setLifecycleOwner(this)

        val adapter = HistoryAdapter(HistoryListner { hId -> viewModel.onHistoryClicked(hId) })
        binding.historyList.adapter = adapter

        return binding.root
    }

}
