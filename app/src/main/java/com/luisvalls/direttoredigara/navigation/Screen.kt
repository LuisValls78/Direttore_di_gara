package com.luisvalls.direttoredigara.navigation

sealed class Screen(val route: String) {
    object AddDispositive : Screen("adddispositive")
    object AddEvent : Screen("addevent")
    object EditEvent : Screen("editevent")
    object EventsRegistered : Screen("eventsregistered")
    object MenuGestion : Screen("menugestion")

    object MenuUsers : Screen("menusuers")
    object ScreenMarkers : Screen("marcadores")
    object ScreenMeteorology : Screen("meteorologia")
    object ScreenRegisterArrival : Screen("llegadas")
    object ScreenViewEvents : Screen("visualizareventos")

}