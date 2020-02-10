package com.example.pokemontool.model

import java.util.*

class History(
    var date: Date,
    var win: Boolean,
    var team: String,
    var opPokemon1: String,
    var opPokemon2: String?,
    var opPokemon3: String?,
    var opPokemon4: String?,
    var opPokemon5: String?,
    var opPokemon6: String?
) {

    fun getFirst3Pokemon(): String {
        return "${opPokemon1} ${opPokemon2} ${opPokemon3}"
    }

    fun getLast3Pokemon(): String {
        return "${opPokemon4} ${opPokemon5} ${opPokemon6}"
    }

}