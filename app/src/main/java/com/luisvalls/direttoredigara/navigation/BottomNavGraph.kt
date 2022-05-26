package com.luisvalls.direttoredigara.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luisvalls.direttoredigara.screens.Amministratore.*
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
            AddDispositive(navController = navController)
        }
        composable(route = Screen.AddEvent.route) {
            AddEvent(navController)
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
        composable(route = Screen.ListDispositives.route) {
            ListDispositives(navController = navController)
        }
        composable(route = Screen.EditDispositives.route) {
            EditDispositive(navController = navController)
        }
        composable(route = Screen.CurrentEventMenu.route) {
            CurrentEventMenu(navController = navController)
        }


    }
}