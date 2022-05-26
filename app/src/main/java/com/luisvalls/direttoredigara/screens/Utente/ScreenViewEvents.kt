package com.luisvalls.direttoredigara.screens.Utente

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisvalls.direttoredigara.navigation.Screen

@Composable
fun ScreenViewEvents(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Registered events") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack(
                        Screen.MenuUsers.route,
                        false
                    )
                }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        "flecha atrás",
                        tint = Color.Black,
                        //modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
            }
        )
    }

    ) {
        LazyColumn() {
            item {
                Spacer(modifier = Modifier.size(10.dp))

                Row() {
                    Column() {
                        Text(text = "Start date: ")
                    }
                    Column() {
                        Text(text = "End date: ")
                    }
                }

                Spacer(modifier = Modifier.size(10.dp))

                Text(text = "Eventos registrados en las fechas seleccionadas: ")

                Spacer(modifier = Modifier.size(8.dp))

                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "+",
                        fontSize = 15.sp,
                        //fontFamily = Poppins,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                    )

                }

            }
        }
    }
}