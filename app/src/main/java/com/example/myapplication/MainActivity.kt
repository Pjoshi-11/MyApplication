package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstNumber = findViewById(R.id.etFirstNumber)
        etSecondNumber = findViewById(R.id.etSecondNumber)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener { calculate("add") }
        btnSubtract.setOnClickListener { calculate("subtract") }
        btnMultiply.setOnClickListener { calculate("multiply") }
        btnDivide.setOnClickListener { calculate("divide") }
    }

    private fun calculate(operation: String) {
        val firstNumber = etFirstNumber.text.toString()
        val secondNumber = etSecondNumber.text.toString()

        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = firstNumber.toDouble()
        val num2 = secondNumber.toDouble()
        var result = 0.0

        when (operation) {
            "add" -> result = num1 + num2
            "subtract" -> result = num1 - num2
            "multiply" -> result = num1 * num2
            "divide" -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }

        tvResult.text = "Result: $result"
    }
}