package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Value

class DotButton(private val view: Button, private val resultField: ResultField) {
    init {
        view.text = Value.DOT.string
        view.setOnClickListener {
            resultField.applyDot()
            true
        }
    }
}