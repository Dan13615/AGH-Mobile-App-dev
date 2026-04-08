package com.example.lab4

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var weight: MutableState<String> = remember { mutableStateOf("") }
            var height: MutableState<String> = remember { mutableStateOf("") }
            var bmi: MutableState<Float> = remember { mutableFloatStateOf(0f) }
            var isClicked: MutableState<Boolean> = remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextField(value = weight.value, onValueChange = {
                        weight.value = it
                    }, placeholder = {
                        Text(text = "Type your weight in KG")
                    })
                    TextField(value = height.value, onValueChange = {
                        height.value = it
                    }, placeholder = {
                        Text(text = "Type your height in M")
                    })
                    Button(onClick = {
                        bmi.value = calculateBMI(weight, height)
                        if (bmi.value == 0f) {
                            Toast.makeText(this@MainActivity, "Invalid Input", LENGTH_LONG).show()
                        } else {
                            isClicked.value = true
                        }
                    }) {
                        Text(text = "Calculate BMI")
                    }
                }
                Column(
                    modifier = Modifier.padding(4.dp).fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    if (isClicked.value) {
                        Text(text = "Your BMI is ${bmi.value}", fontSize = 24.sp)
                        when (bmi.value) {
                            in 0f..18.5f -> {
                                Text(text = "You are underweight", fontSize = 24.sp, color = Color.Red)
                            }

                            in 18.5f..24.9f -> {
                                Text(text = "You are healthy", fontSize = 24.sp, color = Color.Green)
                            }

                            in 25f..29.9f -> {
                                Text(
                                    text = "You are overweight",
                                    fontSize = 24.sp,
                                    color = Color.Yellow
                                )
                            }

                            else -> {
                                Text(text = "You are obese", fontSize = 24.sp, color = Color.Red)
                            }
                        }
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.graph),
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }

    fun calculateBMI(weight: MutableState<String>, height: MutableState<String>): Float {
        val weightValue = weight.value.toFloatOrNull()
        val heightValue = height.value.toFloatOrNull()
        if (weightValue != null && (heightValue != null && heightValue != 0f)) {
            return weightValue / (heightValue * heightValue)
        } else {
            return 0f
        }
    }
}
