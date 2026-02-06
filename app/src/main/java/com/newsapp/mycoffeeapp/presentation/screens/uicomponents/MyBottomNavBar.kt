package com.newsapp.mycoffeeapp.presentation.screens.uicomponents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.newsapp.mycoffeeapp.R
import com.newsapp.mycoffeeapp.presentation.navigation.Routes
import com.newsapp.mycoffeeapp.presentation.theme.LightBrown

@Composable
fun MyBottomNavBar(navController: NavHostController, routes: String) {

    val navItems = listOf(
        NavItem("Home", R.drawable.regular_outline_home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, Routes.CartScreen),
        NavItem("Favourite", R.drawable.regular_outline_heart, Routes.FavouriteScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, Routes.ProfileScreen),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                modifier = Modifier.size(30.dp),
                label = {
                    Text(text = item.title)
                },
                selected = item.title == routes,
                //handelling bottom navigation bar clicks
                onClick = {
                    navController.navigate(route = item.routes) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(alpha = 0.03f),
                )
            )
        }
    }

}

data class NavItem(
    val title: String,
    val icon: Int,
    val routes: Routes
)
