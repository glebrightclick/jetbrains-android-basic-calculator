package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Value

class NumberButton(private val view: Button, private val value: Value, private val resultField: ResultField) {
    init {
        view.text = value.string
        view.setOnClickListener {
            resultField.applyValue(value)
            true
        }
    }
}