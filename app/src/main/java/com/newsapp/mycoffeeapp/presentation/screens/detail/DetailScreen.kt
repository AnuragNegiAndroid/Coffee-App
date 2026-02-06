package com.newsapp.mycoffeeapp.presentation.screens.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.newsapp.mycoffeeapp.R
import com.newsapp.mycoffeeapp.domain.model.Product

@Composable
fun DetailScreen(productId: Int, navController: NavController) {
    val productList = listOf(
        Product(
            id = 1,
            name = "Cappuccino",
            description = "Espresso, hot milk, and steamed milk foam",
            price = 3.99,
            imageRes = R.drawable.coffee_1
        ),
        Product(
            id = 2,
            name = "Espresso",
            description = "Strong and concentrated coffee",
            price = 2.99,
            imageRes = R.drawable.coffee_2
        ),
        Product(
            id = 3,
            name = "Latte",
            description = "Espresso with steamed milk foam",
            price = 3.49,
            imageRes = R.drawable.coffee_3
        ),
        Product(
            id = 4,
            name = "Mocha",
            description = "Espresso, hot milk, and chocolate syrup",
            price = 3.99,
            imageRes = R.drawable.coffee_4
        ),
        Product(
            id = 5,
            name = "Macchiato",
            description = "Espresso with a small amount of hot milk",
            price = 3.49,
            imageRes = R.drawable.coffee_5
        ),
        Product(
            id = 6,
            name = "Americano",
            description = "Espresso with hot water",
            price = 2.99,
            imageRes = R.drawable.coffee_6
        ),
    )

    val selectedProduct = productList.find { it.id == productId }

    if (selectedProduct == null) {
        Text("Product not found")
        return
    }


    Scaffold(
        topBar = { DetailScreenTopAppBar(navController) },
        bottomBar = { DetailScreenBottomBar() }
    ) { innerPadding ->

        LazyColumn() {
            item {
                ProductDetailContent(innerPadding,selectedProduct)
            }
        }

    }
}