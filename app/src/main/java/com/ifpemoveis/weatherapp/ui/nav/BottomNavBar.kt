package com.ifpemoveis.weatherapp.ui.nav

// Anotação @Preview para visualizar o Composable no Android Studio

// Para Composable functions
import androidx.compose.runtime.Composable

// Para NavigationBar e NavigationBarItem (Material3)
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

// Para Text
import androidx.compose.material3.Text

// Para Icon
import androidx.compose.material3.Icon

// Para ImageVector

// Para Color
import androidx.compose.ui.graphics.Color

// Para tamanho de fonte (12.sp)
import androidx.compose.ui.unit.sp

// Para NavController e navegação Compose
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue



@Composable
fun BottomNavBar(navController: NavHostController, items : List<BottomNavItem>) {
    NavigationBar(
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        items.forEach { item ->
            NavigationBarItem (
                icon = { Icon(imageVector = item.icon, contentDescription= item.title)},
                label = { Text(text = item.title, fontSize = 12.sp) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Volta pilha de navegação até HomePage (startDest).
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                            restoreState = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}