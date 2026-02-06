package com.newsapp.mycoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.newsapp.mycoffeeapp.presentation.navigation.NavGraph
import com.newsapp.mycoffeeapp.presentation.screens.cartscreen.CartScreen
import com.newsapp.mycoffeeapp.presentation.screens.detail.DetailScreen
import com.newsapp.mycoffeeapp.presentation.screens.homescreen.HomeScreen
import com.newsapp.mycoffeeapp.presentation.theme.MyCoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffeeAppTheme {
                NavGraph()
            }
        }
    }
}
