package com.example.handyrecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.handyrecipebook.ui.theme.HandyRecipebookTheme

class MainActivity : ComponentActivity() {

    var listOfRecipes = listOf("Chicken Shawarma", "Maqluba", "Lasagna", "Brownies", "Cupcakes", "Chicken Stock", "Lentil Soup", "Fajita", "Honey Mustard Chicken Wrap")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandyRecipebookTheme {

                val navController = rememberNavController()

                var selectedRecipe by remember { mutableStateOf("") }
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "homeScreen"
                    ) {

                        composable(
                            route = "homeScreen",
                            content = {

                                Column(Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                                    .padding(top = 16.dp)
                                    .verticalScroll(state = rememberScrollState())
                                ) {

                                    Text(
                                        "My Handy Recipebook",
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                    Text(
                                        "What are we cooking today?",
                                        modifier = Modifier.padding(start = 16.dp)
                                    )

                                    Column {
                                        for (recipe in listOfRecipes) {
                                            Card(
                                                onClick = {
                                                    selectedRecipe = recipe
                                                    navController.navigate("recipeDetails")
                                                },
                                                modifier = Modifier.fillMaxWidth().padding(16.dp)
                                            ) {
                                                Text(
                                                    recipe,
                                                    modifier = Modifier.fillMaxWidth().padding(24.dp)
                                                )
                                            }
                                            if (recipe == selectedRecipe) {
                                                Text(
                                                    "This is the $recipe recipe!",
                                                    modifier = Modifier.padding(start = 16.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        )

                        composable(
                            route = "recipeDetails",
                            content = {
                                Scaffold(modifier = Modifier.fillMaxSize())
                                { innerPadding ->

                                    Column(
                                        modifier = Modifier.padding(innerPadding)
                                    ) {
                                        Text(
                                            "$selectedRecipe recipe",
                                            modifier = Modifier.padding(16.dp)
                                        )
                                    }

                                }
                            }
                        )
                    }
                }
            }
        }
    }
}