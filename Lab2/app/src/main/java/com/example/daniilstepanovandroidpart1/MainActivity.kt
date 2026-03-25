package com.example.daniilstepanovandroidpart1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daniilstepanovandroidpart1.ui.theme.DaniilStepanovAndroidPart1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val ctx = LocalContext.current
            var txt: MutableState<String> = remember {
                mutableStateOf("This text will be changed")
            }
            var isButtonClicked: MutableState<Boolean> = remember {
                mutableStateOf(false)
            }
            var tfValue: MutableState<String> = remember { mutableStateOf("MyValue") }
            Column (
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxSize(),
            ) {
                Button(onClick = {
                    Log.i("myapp", "Entry from my application")
                }) {
                    Text(text = "My First Button")
                }

                Button(onClick = {
                    Toast.makeText(ctx, "Hello there !", LENGTH_LONG).show()
                }) {
                    Text(text = "Show toast")
                }

                Button(onClick = {
                    txt.value = "My new text"
                }) {
                    Text(text = "Change text")
                }

                Text(
                    text = txt.value,
                    fontSize = 28.sp
                )

                Button(onClick = {
                    isButtonClicked.value = !isButtonClicked.value
                }) {
                    Text(text = "Show up colored text")
                }

                if (isButtonClicked.value) {
                    MyTexts()
                }

                TextField(value = tfValue.value, onValueChange = {
                    tfValue.value = it
                })
            }
//            MyTexts()
        }
    }

    @Composable
    fun MyTexts() {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End

        ) {
            Text(
                text = "Hello there !",
                color = Color.Red,
                fontSize = 20.sp,
                letterSpacing = 3.sp
            )

            Text(
                text = "I'm doing so great",
                color = Color.Blue,
                fontSize = 20.sp,
                letterSpacing = 3.sp
            )

            Text(
                text = "And android is so cool",
                color = Color.Magenta,
                fontSize = 20.sp,
                letterSpacing = 3.sp
            )
        }
    }
}
