package com.example.pokemontool.ui.team

import android.text.InputType
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemontool.Mode
import com.example.pokemontool.database.Team
import com.example.pokemontool.network.DataManager

class TeamDetailViewModel(private val mode: Mode, private val teamId: Long?) : ViewModel() {

    // UI
    var doneButtonVisible = View.GONE
    var editButtonVisible = View.GONE
    var inputType = 0

    // Screen Transition
    private val _navigateToEditMode = MutableLiveData<Boolean>()
    val navigateToEditMode: LiveData<Boolean>
        get() = _navigateToEditMode
    private val _navigateToTeamList = MutableLiveData<Boolean>()
    val navigateToTeamList: LiveData<Boolean>
        get() = _navigateToTeamList

    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team>
        get() = _team

    init {
        when (mode) {
            Mode.ADD -> {
                _team.value = Team()
                setAddMode()
            }
            Mode.EDIT -> {
                _team.value = DataManager.getTeam(teamId!!)
                setEditMode()
            }
            Mode.REFERENCE -> {
                _team.value = DataManager.getTeam(teamId!!)
                setReferenceMode()
            }
        }
    }

    private fun setAddMode() {
        doneButtonVisible = View.VISIBLE
        editButtonVisible = View.GONE
        inputType = InputType.TYPE_CLASS_TEXT
    }

    private fun setEditMode() {
        doneButtonVisible = View.VISIBLE
        editButtonVisible = View.GONE
        inputType = InputType.TYPE_CLASS_TEXT

    }

    private fun setReferenceMode() {
        doneButtonVisible = View.GONE
        editButtonVisible = View.VISIBLE
        inputType = 0
    }

    fun getCheckBoxDisable(): Boolean {
        return mode == Mode.ADD || mode == Mode.EDIT
    }

    fun onClickEdit() {
        _navigateToEditMode.value = true
    }

    fun onClickDone() {
        // TODO: Check required field
        DataManager.submitTeam(team.value!!)
        _navigateToTeamList.value = true
    }

}