package com.luisvalls.direttoredigara.screens.Amministratore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisvalls.direttoredigara.navigation.Screen

@Composable
fun EditEvent(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Edit event") },
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
                Row(){
                    Text(text = "Name: ")
                    //text label
                }

                Row() {
                    Row() {
                        Text(text = "Start date: ")
                        Icon(
                            Icons.Filled.DateRange,
                            "flecha atrás",
                            tint = Color.Black,
                            //modifier = Modifier.padding(horizontal = 5.dp)
                        )
                    }
                    Row() {
                        Text(text = "End date: ")
                        Icon(
                            Icons.Filled.DateRange,
                            "flecha atrás",
                            tint = Color.Black,
                            //modifier = Modifier.padding(horizontal = 5.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.size(10.dp))

                Text(text = "Teams: ")

                Spacer(modifier = Modifier.size(8.dp))

                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Guardar cambios",
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