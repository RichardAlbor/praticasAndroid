package com.ifpemoveis.pratica01.ui.nav

// Para o sealed interface e sealed class
import kotlinx.serialization.Serializable

// Para ImageVector e os ícones padrão (Home, Favorite, LocationOn)
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn

// Para navegação com Compose (caso esteja usando routes como nomes de tela)
import androidx.navigation.NavController


sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object List : Route
    @Serializable
    data object Map : Route
}
sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: Route)
{
    data object HomeButton :
        BottomNavItem("Início", Icons.Default.Home, Route.Home)
    data object ListButton :
        BottomNavItem("Favoritos", Icons.Default.Favorite, Route.List)
    data object MapButton :
        BottomNavItem("Mapa", Icons.Default.LocationOn, Route.Map)
}
