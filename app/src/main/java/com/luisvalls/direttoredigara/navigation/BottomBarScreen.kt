package com.luisvalls.direttoredigara.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Favoritos : BottomBarScreen(
        route = "favoritos",
        title = "Saved",
        icon = Icons.Outlined.Favorite
    )
    object Reservas : BottomBarScreen(
        route = "map",
        title = "Map",
        icon = Icons.Outlined.Call
    )
    object Explorar : BottomBarScreen(
        route = "explorar",
        title = "Explore",
        icon = Icons.Outlined.AccountBox
    )
    object Publicar : BottomBarScreen(
        route = "publicar",
        title = "Publish",
        icon = Icons.Outlined.Email
    )
    object Perfil : BottomBarScreen(
        route = "perfil",
        title = "Profile",
        icon = Icons.Outlined.Face
    )
}