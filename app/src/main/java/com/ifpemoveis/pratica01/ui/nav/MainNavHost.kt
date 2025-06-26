package com.ifpemoveis.pratica01.ui.nav

// Para Composable
import androidx.compose.runtime.Composable

// Para NavController e NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

// Para a função composable com suporte a rotas tipadas (se estiver usando navigation-kotlin-dsl)
import androidx.navigation.compose.composable
import com.ifpemoveis.pratica01.ui.HomePage
import com.ifpemoveis.pratica01.ui.ListPage
import com.ifpemoveis.pratica01.ui.MapPage


@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage() }
        composable<Route.List> { ListPage() }
        composable<Route.Map> { MapPage() }
    }
}

