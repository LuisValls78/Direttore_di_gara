package com.luisvalls.direttoredigara

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.luisvalls.direttoredigara.navigation.BottomBarScreen
import com.luisvalls.direttoredigara.navigation.BottomNavGraph
import com.luisvalls.direttoredigara.screens.Amministratore.MenuGestion
import com.luisvalls.direttoredigara.screens.Utente.MenuUsers


@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold() {
        BottomNavGraph(navController = navController)




    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Favoritos,
        BottomBarScreen.Reservas,
        BottomBarScreen.Explorar,
        BottomBarScreen.Publicar,
        BottomBarScreen.Perfil
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation icon")
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = MaterialTheme.colors.secondary,
        selectedContentColor = MaterialTheme.colors.primary,
        modifier = Modifier.background(MaterialTheme.colors.background),
        onClick = {
            navController.navigate(screen.route)
        }
    )
}