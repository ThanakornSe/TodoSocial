package android.template.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationItem {
    @Serializable
    data object Home : NavigationItem()

    @Serializable
    data class Profile(val name: String) : NavigationItem()
}
