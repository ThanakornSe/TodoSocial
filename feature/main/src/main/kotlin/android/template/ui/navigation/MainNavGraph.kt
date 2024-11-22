package android.template.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@ExperimentalMaterial3Api
fun NavGraphBuilder.homeFeatureNavHost(navController: NavController) {

    navigation<NavigationItem>(startDestination = NavigationItem.Home) {
        composable<NavigationItem.Home> {

        }
        composable<NavigationItem.Profile> {

        }
    }

}