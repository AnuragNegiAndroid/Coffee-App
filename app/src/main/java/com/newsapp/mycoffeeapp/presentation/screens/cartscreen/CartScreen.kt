package com.newsapp.mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.newsapp.mycoffeeapp.R
import com.newsapp.mycoffeeapp.domain.model.Product
import com.newsapp.mycoffeeapp.presentation.screens.uicomponents.MyBottomNavBar
import com.newsapp.mycoffeeapp.presentation.theme.LightBrown

@Composable
fun CartScreen(navController: NavHostController) {

    //displaying products
    val cartProducts = listOf(
        Product(
            id = 1,
            name = "Cappuccino",
            description = "Espresso, hot milk, and steamed milk foam",
            price = 3.99,
            imageRes = R.drawable.coffee_1
        ), Product(
            id = 2,
            name = "Espresso",
            description = "Strong and concentrated coffee",
            price = 2.99,
            imageRes = R.drawable.coffee_2
        ), Product(
            id = 3,
            name = "Latte",
            description = "Espresso with steamed milk foam",
            price = 3.49,
            imageRes = R.drawable.coffee_3
        )

    )

    var amount by remember { mutableStateOf(12.0) }
    var deliveryFee by remember { mutableStateOf(14.0) }
    var totalAmount by remember { mutableStateOf(amount + deliveryFee) }


    Scaffold(
        topBar = { CartScreenTopAppBar(navController) },
        bottomBar = { MyBottomNavBar(navController = navController, "Cart") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row() {
                    Text(
                        "Deliver",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                cartProducts.forEach { product ->
                    CartItemsCard(product)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment Summary", style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Price", fontWeight = FontWeight.SemiBold, fontSize = 18.sp
                    )
                    Text(
                        "$ $amount", fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Delivery Fees", fontWeight = FontWeight.SemiBold, fontSize = 18.sp
                    )
                    Text(
                        "$ $deliveryFee", fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCard(totalAmount)


            }
        }
    }

}