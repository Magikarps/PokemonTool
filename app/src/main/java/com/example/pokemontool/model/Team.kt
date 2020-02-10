package com.example.pokemontool.model

class Team(
    var teamName: String,
    var pokemon1: String,
    var pokemon2: String?,
    var pokemon3: String?,
    var pokemon4: String?,
    var pokemon5: String?,
    var pokemon6: String?
) {

    fun getFirst3Pokemon(): String {
        return "${pokemon1} ${pokemon2} ${pokemon3}"
    }

    fun getLast3Pokemon(): String {
        return "${pokemon4} ${pokemon5} ${pokemon6}"
    }

}