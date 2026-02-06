package com.newsapp.mycoffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.newsapp.mycoffeeapp.presentation.screens.cartscreen.CartScreen
import com.newsapp.mycoffeeapp.presentation.screens.detail.DetailScreen
import com.newsapp.mycoffeeapp.presentation.screens.favoritescreen.FavoriteScreen
import com.newsapp.mycoffeeapp.presentation.screens.homescreen.HomeScreen
import com.newsapp.mycoffeeapp.presentation.screens.profilescreen.ProfileScreen
import com.newsapp.mycoffeeapp.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            //val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            DetailScreen(productId = args.productId, navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.FavouriteScreen> {
            FavoriteScreen(navController)
        }

        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)
        }

    }
}