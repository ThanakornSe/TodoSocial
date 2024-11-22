package android.template.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = NavigationItem) {
        homeFeatureNavHost(navController = navController)
    }
}