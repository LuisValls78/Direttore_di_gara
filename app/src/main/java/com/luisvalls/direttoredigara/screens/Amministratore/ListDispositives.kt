package com.luisvalls.direttoredigara.screens.Amministratore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisvalls.direttoredigara.data.event
import com.luisvalls.direttoredigara.navigation.Screen


@Composable
fun ListDispositives(navController: NavController) {

    val eventsList: List<event> = emptyList<event>() + event("1234", "Regata")

    val dateStart = remember { mutableStateOf("26/05/2022") }
    val dateEnd = remember { mutableStateOf("28/05/2022") }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "DISPOSITIVE REGISTERED") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(route = Screen.MenuGestion.route)

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
    }) {


        Column(Modifier.padding(start = 20.dp, end = 25.dp, top = 30.dp)) {

            Spacer(modifier = Modifier.size(8.dp))

            Row() {

                Row() {
                    Row() {
                        Column() {
                            Row() {
                                Text(text = "Start date: ")

                                Icon(
                                    Icons.Filled.DateRange,
                                    "flecha atrás",
                                    tint = Color.Black,
                                    //modifier = Modifier.padding(horizontal = 5.dp)
                                )
                            }
                            TextField(
                                value = dateStart.value,
                                onValueChange = {
                                    if (it.length <= 10) dateStart.value = it
                                },
                                label = { Text(text = "") },
                                singleLine = false,
                                shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                                modifier = Modifier.width(125.dp),
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(20.dp))

                    Row(horizontalArrangement = Arrangement.End) {
                        Column() {
                            Row() {
                                Text(text = "End date: ")

                                Icon(
                                    Icons.Filled.DateRange,
                                    "flecha atrás",
                                    tint = Color.Black,
                                    //modifier = Modifier.padding(horizontal = 5.dp)
                                )
                            }
                            TextField(
                                value = dateEnd.value,
                                onValueChange = {
                                    if (it.length <= 144) dateEnd.value = it
                                },
                                label = { Text(text = "") },
                                singleLine = false,
                                shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.width(125.dp),
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))

                Button(
                    onClick = {
                        navController.navigate(route = Screen.ListDispositives.route)

                    },
                    //shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                    modifier = Modifier.width(160.dp).align(Alignment.CenterVertically).padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Icon(
                        Icons.Filled.Refresh,
                        "refresh",
                        tint = Color.Black,
                        //modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.size(50.dp))

            Text(text = "Eventos registrados:")

            Spacer(modifier = Modifier.size(20.dp))


            LazyColumn(
                Modifier.border(
                    border = BorderStroke(1.dp, Color.Black),
                ).align(Alignment.CenterHorizontally).padding(start = 5.dp)
            ) {
                itemsIndexed(eventsList) { index, actividada ->
                    if (index == 0) {
                        dispositiveItem(navController)
                    } else if (index == eventsList.size - 1) {
                        dispositiveItem(navController)
                    } else {
                        dispositiveItem(navController)
                    }
                }
            }


        }
    }
}


@Composable
fun dispositiveItem(navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "dispositive name")

        Spacer(modifier = Modifier.size(20.dp))

        IconButton(onClick = {
            navController.navigate(route = Screen.EditEvent.route)
        }) {
            Icon(
                Icons.Filled.Edit,
                "edit icon",
                tint = Color.Black,
                //modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Delete,
                "basura icon",
                tint = Color.Black,
                //modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
    }
}