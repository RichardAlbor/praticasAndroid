package com.ifpemoveis.pratica01.ui.nav

// Para Composable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

// Para NavController e NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

// Para a função composable com suporte a rotas tipadas (se estiver usando navigation-kotlin-dsl)
import androidx.navigation.compose.composable
import com.ifpemoveis.pratica01.ui.HomePage
import com.ifpemoveis.pratica01.ui.ListPage
import com.ifpemoveis.pratica01.ui.MapPage
import com.ifpemoveis.pratica01.ui.main.MainViewModel


@Composable
fun MainNavHost(navController: NavHostController, viewModel: MainViewModel ) {

    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage(viewModel) }
        composable<Route.List> { ListPage(viewModel) }
        composable<Route.Map> { MapPage(viewModel) }
    }
}

