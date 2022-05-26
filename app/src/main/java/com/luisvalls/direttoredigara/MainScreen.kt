package com.luisvalls.direttoredigara

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.luisvalls.direttoredigara.navigation.BottomNavGraph



@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold() {
        BottomNavGraph(navController = navController)
    }
}
