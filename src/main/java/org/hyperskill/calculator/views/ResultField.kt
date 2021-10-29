package org.hyperskill.calculator.views

import android.widget.EditText
import org.hyperskill.calculator.enum.Operator
import org.hyperskill.calculator.enum.Value
import java.lang.Exception
import kotlin.math.floor
import kotlin.properties.Delegates

class ResultField(private val view: EditText, private val initialViewValue : String = Value.ZERO.string) {
    private var memoryValue : String? = null
    private var contextOperator : Operator? = null
    private var contextValue : String by Delegates.observable(initialViewValue) {
        _, _, newValue -> view.setText(newValue)
    }
    private var hint : String by Delegates.observable(initialViewValue) {
        _, _, newValue -> view.hint = newValue
    }

    private fun isEmpty() = contextValue.replace(Operator.SUBTRACT.string, "") == initialViewValue

    fun applyDot() {
        if (contextValue.contains(Value.DOT.string)) return

        contextValue = contextValue +
            (if (contextValue == Operator.SUBTRACT.string) initialViewValue else "") +
            Value.DOT.string
    }

    fun applyValue(value: Value) {
        contextValue = (if (isEmpty()) contextValue.replace(initialViewValue, "") else contextValue) +
            value.string
    }

    fun clear() {
        contextValue = initialViewValue
        hint = initialViewValue
    }

    fun setOperator(operator: Operator) {
        contextOperator = operator
        memoryValue = contextValue

        contextValue = Value.EMPTY.string
        hint = memoryValue!!
    }

    fun setSubtractOperator() =
        if (isEmpty()) {
            contextValue = Operator.SUBTRACT.string
        } else {
            setOperator(Operator.SUBTRACT)
        }

    fun calculate() {
        if (memoryValue === null || contextOperator === null) return

        val doubleContextValue = contextValue.toDouble()
        val doubleMemoryValue = memoryValue!!.toDouble()
        val result = when (contextOperator) {
            Operator.ADD ->
                doubleMemoryValue + doubleContextValue
            Operator.SUBTRACT ->
                doubleMemoryValue - doubleContextValue
            Operator.MULTIPLY ->
                doubleMemoryValue * doubleContextValue
            Operator.DIVIDE ->
                if (doubleContextValue != 0.0) doubleMemoryValue / doubleContextValue else throw Exception("DIVISION BY ZERO")
            else ->
                return
        }

        memoryValue = null
        contextOperator = null
        contextValue = if (result == floor(result)) result.toInt().toString() else result.toString()
    }
}
