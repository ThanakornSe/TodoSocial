package com.thanakorn.todo.feature.main.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thanakorn.todo.ui.navigation.NavigationItem

@ExperimentalMaterial3Api
fun NavGraphBuilder.homeFeatureNavHost(navController: NavController) {

    navigation<NavigationItem>(startDestination = NavigationItem.Home) {
        composable<NavigationItem.Home> {

        }
        composable<NavigationItem.Profile> {

        }
    }

}