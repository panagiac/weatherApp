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
    val activity = context as Activity
    setAdapter(
        ArrayAdapter(
            activity,
            android.R.layout.simple_list_item_1,
            list
        ).apply {
            onItemClickListener =
                AdapterView.OnItemClickListener { parent, _, position, _ ->
                    val item = parent.getItemAtPosition(position)
                    activity.hideKeyboard()
                    autoCompleteTextView.clearFocus()

                    delay({ onClick.invoke(item as String) })
                }
        }
    )

    return this
}