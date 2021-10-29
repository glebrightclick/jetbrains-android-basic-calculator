package org.hyperskill.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.hyperskill.calculator.enum.Operator
import org.hyperskill.calculator.enum.Value
import org.hyperskill.calculator.views.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = ResultField(findViewById(R.id.editText))

        ClearButton(findViewById(R.id.clearButton), editText)

        NumberButton(findViewById(R.id.button0), Value.ZERO, editText)
        NumberButton(findViewById(R.id.button1), Value.ONE, editText)
        NumberButton(findViewById(R.id.button2), Value.TWO, editText)
        NumberButton(findViewById(R.id.button3), Value.THREE, editText)
        NumberButton(findViewById(R.id.button4), Value.FOUR, editText)
        NumberButton(findViewById(R.id.button5), Value.FIVE, editText)
        NumberButton(findViewById(R.id.button6), Value.SIX, editText)
        NumberButton(findViewById(R.id.button7), Value.SEVEN, editText)
        NumberButton(findViewById(R.id.button8), Value.EIGHT, editText)
        NumberButton(findViewById(R.id.button9), Value.NINE, editText)

        DotButton(findViewById(R.id.dotButton), editText)

        OperationButton(findViewById(R.id.addButton), Operator.ADD, editText)
        SubtractButton(findViewById(R.id.subtractButton), editText)
        OperationButton(findViewById(R.id.multiplyButton), Operator.MULTIPLY, editText)
        OperationButton(findViewById(R.id.divideButton), Operator.DIVIDE, editText)

        EqualButton(findViewById(R.id.equalButton), editText)
    }
}