package org.hyperskill.calculator.views

import android.widget.Button
import org.hyperskill.calculator.enum.Operator

open class OperationButton(private val view : Button, private val operator: Operator, private val resultField: ResultField) {
    init {
        view.text = operator.string
        view.setOnClickListener {
            listener()
            true
        }
    }

    protected open fun listener() {
        resultField.setOperator(operator)
    }
}