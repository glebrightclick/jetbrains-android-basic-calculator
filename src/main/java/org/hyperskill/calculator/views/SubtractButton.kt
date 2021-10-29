package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Operator

class SubtractButton(private val view : Button, private val resultField: ResultField) : OperationButton(view, Operator.SUBTRACT, resultField) {
    override fun listener() {
        resultField.setSubtractOperator()
    }
}