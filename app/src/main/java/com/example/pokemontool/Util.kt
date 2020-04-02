package com.example.pokemontool

import com.example.pokemontool.database.History

fun getFirst3Pokemon(h: History): String {
    return get3PokemonStr(h.opPokemon1, h.opPokemon2, h.opPokemon3)
}

fun getLast3Pokemon(h: History): String {
    return get3PokemonStr(h.opPokemon4, h.opPokemon5, h.opPokemon6)
}

fun get3PokemonStr(p1: String?, p2: String?, p3: String?): String {
    return "$p1 $p2 $p3"
}