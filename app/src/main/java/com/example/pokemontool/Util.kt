package com.example.pokemontool

import com.example.pokemontool.database.History
import com.example.pokemontool.database.Team

fun getFirst3Pokemon(h: History): String {
    return get3PokemonStr(h.opPokemon1, h.opPokemon2, h.opPokemon3)
}

fun getLast3Pokemon(h: History): String {
    return get3PokemonStr(h.opPokemon4, h.opPokemon5, h.opPokemon6)
}

fun getFirst3Pokemon(t: Team): String {
    return get3PokemonStr(t.pokemon1, t.pokemon2, t.pokemon3)
}

fun getLast3Pokemon(t: Team): String {
    return get3PokemonStr(t.pokemon4, t.pokemon5, t.pokemon6)
}

fun get3PokemonStr(p1: String?, p2: String?, p3: String?): String {
    var result = ""
    p1?.let{ result += p1 }
    p2?.let{ result += " $p2" }
    p3?.let{ result += " $p3" }

    return result
}


enum class Mode {
    ADD, EDIT, REFERENCE
}
