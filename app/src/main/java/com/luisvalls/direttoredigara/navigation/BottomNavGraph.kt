package com.luisvalls.direttoredigara.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luisvalls.direttoredigara.screens.Amministratore.EditEvent
import com.luisvalls.direttoredigara.screens.Amministratore.EventsRegistered
import com.luisvalls.direttoredigara.screens.Amministratore.MenuGestion
import com.luisvalls.direttoredigara.screens.Utente.MenuUsers
import com.luisvalls.direttoredigara.screens.Utente.ScreenViewEvents

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.MenuGestion.route
    ) {

        composable(route = Screen.MenuUsers.route) {
            MenuUsers()
        }
        composable(route = Screen.ScreenMarkers.route) {
            MenuUsers()
        }
        composable(route = Screen.AddDispositive.route) {
            MenuUsers()
        }
        composable(route = Screen.AddEvent.route) {
            MenuUsers()
        }
        composable(route = Screen.EditEvent.route) {
            EditEvent(navController)
        }
        composable(route = Screen.EventsRegistered.route) {

            EventsRegistered(navController)
        }
        composable(route = Screen.ScreenMeteorology.route) {
            MenuUsers()
        }
        composable(route = Screen.ScreenViewEvents.route) {

            ScreenViewEvents(navController = navController)
        }
        composable(route = Screen.ScreenRegisterArrival.route) {
            MenuUsers()
        }
        composable(route = Screen.MenuGestion.route) {
            MenuGestion(navController = navController)
        }


    }
}