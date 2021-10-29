package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Operator

class EqualButton(private val view: Button, private val resultField: ResultField) {
    init {
        view.text = Operator.EQUAL.string
        view.setOnClickListener {
            resultField.calculate()
            true
        }
    }
}