package com.example.pokemontool.ui.team

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.pokemontool.database.Team
import com.example.pokemontool.getFirst3Pokemon
import com.example.pokemontool.getLast3Pokemon

@BindingAdapter("First3Pokemon")
fun TextView.setFirst3Pokemon(item: Team?) {
    item?.let {
        text = getFirst3Pokemon(item)
    }
}

@BindingAdapter("Last3Pokemon")
fun TextView.setLast3Pokemon(item: Team?) {
    item?.let {
        text = getLast3Pokemon(item)
    }
}