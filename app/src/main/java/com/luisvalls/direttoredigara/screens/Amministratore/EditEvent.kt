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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
fun EditEvent(navController: NavController) {

    val eventsList: List<event> = emptyList<event>() + event("1234", "Regata")

    val dateStart = remember { mutableStateOf("26/05/2022") }
    val dateEnd = remember { mutableStateOf("28/05/2022") }

    val nameTextField = remember { mutableStateOf("Valencia Cup") }


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
        Column(Modifier.padding(start = 20.dp, end = 25.dp, top = 40.dp)) {
            Column() {
                Text(text = "Name: ")

                TextField(
                    value = nameTextField.value,
                    onValueChange = {
                        if (it.length <= 15) nameTextField.value = it
                    },
                    label = { Text(text = "") },
                    singleLine = false,
                    shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                    modifier = Modifier.width(200.dp),
                )
            }

            Spacer(modifier = Modifier.size(50.dp))

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


            }
            Spacer(modifier = Modifier.size(50.dp))

            Text(text = "Team members: ")

            Spacer(modifier = Modifier.size(20.dp))


            LazyColumn(
                Modifier
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                    )
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 5.dp)
            ) {
                itemsIndexed(eventsList) { index, actividada ->
                    if (index == 0) {
                        miembroEquipoItem(navController)
                    } else if (index == eventsList.size - 1) {
                        miembroEquipoItem(navController)
                    } else {
                        miembroEquipoItem(navController)
                    }
                }
            }


            Spacer(modifier = Modifier.size(50.dp))

            Button(
                onClick = {
                    navController.navigate(route = Screen.EventsRegistered.route)

                },
                //shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                modifier = Modifier.width(160.dp).align(CenterHorizontally),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, Color.Black),
            ) {
                Text(
                    text = "Save Changes",
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


@Composable
fun miembroEquipoItem(navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Luis Valls")

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