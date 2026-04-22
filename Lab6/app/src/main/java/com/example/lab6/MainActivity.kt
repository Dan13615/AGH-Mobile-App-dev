package com.example.lab6

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.lab6.databinding.ActivityActionsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActionsBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityActionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = ViewModelProvider(this)[User::class.java]
        user.firstName = MutableLiveData("John")
        user.lastName = MutableLiveData("Doe")

        binding.user = user
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setWriteToLogacatButtonListener()
        setShowToastButtonListener()
        setWriteToTextViewButtonListener()
        setUpdateUserDataButton()
    }

    private fun setWriteToLogacatButtonListener() {
        binding.btnWriteToLogcat.setOnClickListener {
            Log.i("MyAppList", "Message from the BindListener")
        }
    }

    fun writeToLogCat(view: View) {
        Log.i("MainActivity", "Button clicked")
    }

    private fun setShowToastButtonListener() {
        binding.btnShowToast.setOnClickListener {
            Toast.makeText(
                this,
                "Message from App",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setWriteToTextViewButtonListener() {
        binding.btnWriteSomething.setOnClickListener {
            binding.tvWriteSomething.text = getString(R.string.i_love_this_game)
        }
    }

    private fun setUpdateUserDataButton() {
        binding.btnUpdateUser.setOnClickListener {
            user.lastName = MutableLiveData("Smith")
            binding.user = user
        }
    }
}