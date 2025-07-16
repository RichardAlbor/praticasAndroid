package com.ifpemoveis.weatherapp.ui.nav

// Para Composable
import androidx.compose.runtime.Composable

// Para NavController e NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

// Para a função composable com suporte a rotas tipadas (se estiver usando navigation-kotlin-dsl)
import androidx.navigation.compose.composable
import com.ifpemoveis.weatherapp.ui.HomePage
import com.ifpemoveis.weatherapp.ui.ListPage
import com.ifpemoveis.weatherapp.ui.MapPage
import com.ifpemoveis.weatherapp.ui.main.MainViewModel


@Composable
fun MainNavHost(navController: NavHostController, viewModel: MainViewModel ) {

    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage(viewModel) }
        composable<Route.List> { ListPage(viewModel) }
        composable<Route.Map> { MapPage(viewModel) }
    }
}

