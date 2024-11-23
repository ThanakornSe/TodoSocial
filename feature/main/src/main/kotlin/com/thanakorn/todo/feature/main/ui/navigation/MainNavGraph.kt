package com.thanakorn.todo.feature.main.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thanakorn.todo.feature.main.ui.home.HomeMainScreen
import com.thanakorn.todo.ui.navigation.Home
import com.thanakorn.todo.ui.navigation.Screen

@ExperimentalMaterial3Api
fun NavGraphBuilder.homeFeatureNavHost(navController: NavHostController) {

    navigation<Screen>(startDestination = Home) {
        composable<Home> {
            HomeMainScreen(navController = navController)
        }
    }

}