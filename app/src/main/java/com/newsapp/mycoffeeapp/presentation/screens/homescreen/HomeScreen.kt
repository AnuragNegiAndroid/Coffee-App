package com.newsapp.mycoffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.newsapp.mycoffeeapp.R
import com.newsapp.mycoffeeapp.domain.model.Product
import com.newsapp.mycoffeeapp.presentation.screens.uicomponents.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavHostController) {

    val location = "India"
    Scaffold(
        bottomBar = { MyBottomNavBar(navController,"Home") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {


            //displaying products
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

            ProductsGrid(productList,navController) {
                Text(
                    "Location",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(location, color = Color.White)
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Change location",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                MySearchBar()

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Banner"
                )

                Spacer(modifier = Modifier.height(30.dp))

                HomeScreenCategory()
            }

        }

    }
}