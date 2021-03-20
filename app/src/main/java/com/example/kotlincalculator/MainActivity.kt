package com.example.kotlincalculator

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


//setar controles- https://developer.android.com/guide/topics/ui/declaring-layout?hl=pt-br
//botoes - https://developer.android.com/guide/topics/ui/controls/button?hl=pt-br#kotlin
//events - https://developer.android.com/guide/topics/ui/ui-events?hl=pt-br

class MainActivity : AppCompatActivity() {
    private val editTextNumber1 by lazy { findViewById<EditText>(R.id.editTextNumber1) }
    private val editTextNumber2 by lazy { findViewById<EditText>(R.id.editTextNumber2) }
    private val textViewResult by lazy { findViewById<TextView>(R.id.result) }
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtons()
    }

    private fun setupButtons() {
        val buttonSum: Button = findViewById(R.id.buttonSum)
        val buttonSubtraction: Button = this.findViewById(R.id.buttonSubtraction)
        val buttonMultiplication: Button = findViewById(R.id.buttonMultiplication)
        val buttonDivision: Button = findViewById(R.id.buttonDivision)

        buttonSum.setOnClickListener {
            calculate(MathOperation.SUM)
        }

        buttonSubtraction.setOnClickListener {
            calculate(MathOperation.SUBTRACTION)
        }

        buttonMultiplication.setOnClickListener {
            calculate(MathOperation.MULTIPLICATION)
        }

        buttonDivision.setOnClickListener {
            calculate(MathOperation.DIVISION)
        }
    }

    private fun calculate(operation: MathOperation) {
        val inputs = getInputs()
        val result = when(operation) {
            MathOperation.SUM -> calculator.sum(inputs[0], inputs[1])
            MathOperation.SUBTRACTION -> calculator.subtraction(inputs[0], inputs[1])
            MathOperation.MULTIPLICATION -> calculator.multiplication(inputs[0], inputs[1])
            MathOperation.DIVISION -> calculator.division(inputs[0], inputs[1])
        }
        textViewResult.text = result.toString()
        hideKeyboard()
    }

    private enum class MathOperation {
        SUM, SUBTRACTION, DIVISION, MULTIPLICATION
    }

    private fun hideKeyboard(){
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
                .toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    private fun getInputs(): List<Float> {
        val number1String: String = editTextNumber1.text.toString()
        val number2String: String = editTextNumber2.text.toString()
        val number1: Float = number1String.toFloat()
        val number2: Float = number2String.toFloat()

        return listOf(number1, number2)
    }
}
