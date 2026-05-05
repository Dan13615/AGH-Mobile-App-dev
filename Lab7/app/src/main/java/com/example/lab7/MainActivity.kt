package com.example.lab7

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.lab7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var value: Value
    private var buffer: Double = 0.0
    private var operation: String = ""
    private var shouldClearDisplay: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        value = ViewModelProvider(this)[Value::class.java]
        if (value.x.value == null) {
            value.x.value = "0"
        }

        binding.value = value
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun addNewChar1(view: View) = append("1")
    fun addNewChar2(view: View) = append("2")
    fun addNewChar3(view: View) = append("3")
    fun addNewChar4(view: View) = append("4")
    fun addNewChar5(view: View) = append("5")
    fun addNewChar6(view: View) = append("6")
    fun addNewChar7(view: View) = append("7")
    fun addNewChar8(view: View) = append("8")
    fun addNewChar9(view: View) = append("9")
    fun addNewChar0(view: View) = append("0")
    fun addNewCharDot(view: View) = append(".")

    fun onClear(view: View) {
        value.x.value = "0"
        buffer = 0.0
        operation = ""
        shouldClearDisplay = false
    }

    fun addition(view: View) = setOperation("+")
    fun subtraction(view: View) = setOperation("-")
    fun multiplication(view: View) = setOperation("*")
    fun division(view: View) = setOperation("/")

    private fun setOperation(op: String) {
        val currentText = value.x.value ?: "0"
        if (operation.isNotEmpty() && !shouldClearDisplay) {
            calculate()
        } else {
            buffer = currentText.toDoubleOrNull() ?: 0.0
        }
        operation = op
        shouldClearDisplay = true
    }

    fun onEqual(view: View) {
        if (operation.isNotEmpty()) {
            calculate()
            operation = ""
            shouldClearDisplay = true
        }
    }

    private fun calculate() {
        val currentText = value.x.value ?: "0"
        val current = currentText.toDoubleOrNull() ?: 0.0
        val result = when (operation) {
            "+" -> buffer + current
            "-" -> buffer - current
            "*" -> buffer * current
            "/" -> if (current != 0.0) buffer / current else Double.NaN
            else -> current
        }
        
        value.x.value = if (result.isNaN()) "Error" else {
            if (result % 1 == 0.0) result.toLong().toString() else result.toString()
        }
        buffer = if (result.isNaN()) 0.0 else result
    }

    private fun append(char: String) {
        if (shouldClearDisplay || value.x.value == "0" || value.x.value == "Error") {
            if (char == ".") {
                value.x.value = "0."
            } else {
                value.x.value = char
            }
            shouldClearDisplay = false
        } else {
            if (char == "." && value.x.value?.contains(".") == true) return
            value.x.value = (value.x.value ?: "") + char
        }
    }
}
