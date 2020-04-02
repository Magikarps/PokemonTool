package com.example.pokemontool.ui.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.pokemontool.R

class RecordTeamSelectFragment : Fragment() {
    private lateinit var nextButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_record_team_select, container, false)
        nextButton = view.findViewById(R.id.next_button)
        nextButton.setOnClickListener(View.OnClickListener {
            var navController = findNavController()
            navController.navigate(R.id.action_recordTeamSelectFragment_to_recordInputFragment)
        })

        return view
    }

}
