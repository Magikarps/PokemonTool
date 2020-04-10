package com.example.pokemontool.ui.team

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import com.example.pokemontool.R
import com.example.pokemontool.database.Pokemon

class PokemonAdapter(context: Context, private val resource: Int, val list: List<Pokemon>) :
    ArrayAdapter<Pokemon>(context, resource, list) {

    private val filter = PokemonFilter(this)
    val nameList = list.map { pokemon ->  pokemon.nameEn}

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val activity = context as Activity
        val view = convertView ?: activity.layoutInflater.inflate(resource, parent, false)

        val keyText: TextView = view.findViewById(R.id.text_key)
        val valText: TextView = view.findViewById(R.id.text_val)

        val item = getItem(position)
        item?.let {
            keyText.text = item.pokemonId
            valText.text = item.nameEn
        }

        return view
    }

    override fun getFilter(): Filter {
        return filter
    }

    class PokemonFilter(private val adapter: PokemonAdapter) : Filter() {
        private val list = adapter.list.toList()

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val result = FilterResults()
            if (constraint == null || constraint.isEmpty()) {
                result.values = listOf(list)
                result.count = list.size
            } else {
                val prefix = constraint.toString().toLowerCase()
                val newList = mutableListOf<Pokemon>()
                val count = list.size
                for (i in 0 until count) {
                    val value = list[i]
                    val text = value.nameEn.toLowerCase()
                    if (text.startsWith(prefix)) newList.add(value)
                }
                result.values = newList
                result.count = newList.size

            }

            return result
        }

        override fun convertResultToString(resultValue: Any?): CharSequence {
            val p = resultValue as Pokemon
            return p.nameEn
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            adapter.clear()
            if (results != null && results.count > 0) {
                val tmp = results.values as List<Pokemon>
                adapter.addAll(tmp)
            }
            adapter.notifyDataSetChanged()
        }
    }


}