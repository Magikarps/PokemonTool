package com.example.pokemontool.ui.team

import android.text.InputType
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pokemontool.Mode
import com.example.pokemontool.database.Pokemon
import com.example.pokemontool.database.PokemonDao
import com.example.pokemontool.database.Team
import com.example.pokemontool.network.RepositoryManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamDetailViewModel(
    private val mode: Mode,
    teamId: Long?,
    private val dataSource: PokemonDao
) :
    ViewModel() {

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
    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    // Data
    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team>
        get() = _team
    val allPokemon = liveData {
        val data = getAllPokemon()
        emit(data)
    }

    init {
        when (mode) {
            Mode.ADD -> {
                _team.value = Team()
                setAddMode()
            }
            Mode.EDIT -> {
                _team.value = RepositoryManager.getTeam(teamId!!)
                setEditMode()
            }
            Mode.REFERENCE -> {
                _team.value = RepositoryManager.getTeam(teamId!!)
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
        if (RepositoryManager.submitTeam(team.value!!)) {
            _message.value = "Successfully added a team"
            _navigateToTeamList.value = true
        } else {
            _message.value = "Network failed. Please try again."
        }
    }

    private suspend fun getAllPokemon(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            dataSource.getAll()
        }
    }
}