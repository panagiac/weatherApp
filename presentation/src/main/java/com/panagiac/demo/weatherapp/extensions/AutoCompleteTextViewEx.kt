package com.panagiac.demo.weatherapp.extensions

import android.app.Activity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

fun AutoCompleteTextView.build(
    list: List<String>,
    onClick: (String) -> Unit
): AutoCompleteTextView {
    val autoCompleteTextView = this

    setAdapter(
        ArrayAdapter(
            context as Activity,
            android.R.layout.simple_list_item_1,
            list
        ).apply {
            onItemClickListener =
                AdapterView.OnItemClickListener { parent, _, position, _ ->
                    val item = parent.getItemAtPosition(position)
                    autoCompleteTextView.clearFocus()
                    autoCompleteTextView.hideKeyboard()

                    delay({ onClick.invoke(item as String) })
                }
        }
    )

    return this
}