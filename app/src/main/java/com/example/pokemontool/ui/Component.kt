package com.example.pokemontool.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View.OnFocusChangeListener
import android.widget.AutoCompleteTextView
import com.example.pokemontool.R
import com.example.pokemontool.ui.team.PokemonAdapter
import com.google.android.material.textfield.TextInputLayout

class TextInputLayoutWithValidator : TextInputLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setEditTextValidator() {
        this.editText!!.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            val input = this.editText!!.text.toString()
            if (!hasFocus && input.isEmpty()) {
                this.error =
                    context.getString(R.string.error_required_message)
            } else {
                this.error = null
            }
        }
    }

    fun setAutoCompValidator(required: Boolean) {
        val adapter = (this.editText as AutoCompleteTextView).adapter as PokemonAdapter
        this.editText!!.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            val input = this.editText!!.text.toString()

            if (!hasFocus && required && input.isEmpty()) {
                this.error =
                    context.getString(R.string.error_required_message)
            } else if (!hasFocus && !adapter.nameList.contains(input)) {
                this.error =
                    context.getString(R.string.error_invalid_input_message)
            } else {
                this.error = null
            }
        }
    }

}