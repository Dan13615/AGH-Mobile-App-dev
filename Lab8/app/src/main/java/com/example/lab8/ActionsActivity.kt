package com.example.lab8

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab8.databinding.ActivityActionsBinding

class ActionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writeToLogCatBtn.setOnClickListener {
            Log.d("ActionsActivity", "Write to LogCat button clicked!")
        }

        binding.showToastBtn.setOnClickListener {
            Toast.makeText(this, "Hello from ActionsActivity!", Toast.LENGTH_SHORT).show()
        }

        binding.writeToEditTextBtn.setOnClickListener {
            binding.outputEditText.setText("Text written from button click!")
        }

        binding.backToFirstFragmentBtn.setOnClickListener {
            finish()
        }
    }
}