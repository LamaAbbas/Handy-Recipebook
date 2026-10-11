package com.example.handyrecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handyrecipebook.ui.theme.HandyRecipebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandyRecipebookTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    Column(Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(top = 16.dp)
                        .padding(start = 10.dp)
                    )
                    {
                        Greeting(
                            "My Handy Recipebook"
                        )
                        Greeting(
                            "What are we cooking today?"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HandyRecipebookTheme {
        Greeting("Android")
    }
}