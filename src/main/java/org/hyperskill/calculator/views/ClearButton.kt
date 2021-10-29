package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Operator

class ClearButton(view: Button, resultField: ResultField) {
    init {
        view.text = Operator.CLEAR.string
        view.setOnClickListener {
            resultField.clear()
            true
        }
    }
}