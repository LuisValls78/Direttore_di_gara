package com.luisvalls.direttoredigara.screens.Amministratore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.luisvalls.direttoredigara.data.Markers.Companion.valenciaMarkers
import com.luisvalls.direttoredigara.navigation.Screen

@Composable
fun CurrentEventMenu(navController: NavController) {

    var dialogMarker by remember { mutableStateOf(false) }
    var dialogWeather by remember { mutableStateOf(false) }
    var dialogArrival by remember { mutableStateOf(false) }

    var valueLatDialog by remember {
        mutableStateOf(
            "Latitude"
        )
    }
    var valueLongDialog by remember {
        mutableStateOf(
            "Longitude"
        )
    }
    var valueNumberDialog by remember {
        mutableStateOf(
            "Boat number"
        )
    }


    //map properties
    val properties by remember {
        mutableStateOf(
            MapProperties(
                //isMyLocationEnabled = false,
                maxZoomPreference = 21.0f,
                minZoomPreference = 4.0f,
            )
        )
    }
    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(

            )
        )
    }
    val posicionInicialCamara = rememberCameraPositionState {
        position =
            CameraPosition.fromLatLngZoom(LatLng(39.467947212925445, -0.31757110760524765), 13f)
    }
    val context = LocalContext.current

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "America's Cup Valencia") },
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
            }, actions = {
                IconButton(onClick = {
                    dialogWeather = true
                }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.WbCloudy,
                            "icono clima",
                            tint = Color.White,
                            //modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(text = "Weather")

                    }


                }
            }
        )
    }) {

        GoogleMap(
            modifier = Modifier
                .fillMaxSize(),
            properties = properties,
            uiSettings = uiSettings,
            cameraPositionState = posicionInicialCamara
        ) {
            valenciaMarkers.forEach {
                Marker(
                    position = LatLng(it.latitude, it.longitude),
                    title = it.name,
                    tag = "Valencia",
                    //iconResourceId = R.drawable.pizza
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            Spacer(modifier = Modifier.size(625.dp))

            Row() {

                Button(
                    onClick = {
                        dialogArrival = true
                    },
                    shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),
                    modifier = Modifier.width(160.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Text(
                        text = "Register arrival",
                        fontSize = 15.sp,
                        //fontFamily = Poppins,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            //.padding(top = 30.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.size(50.dp))

                Button(
                    onClick = {
                        dialogMarker = true
                    },
                    shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),
                    modifier = Modifier.width(160.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Text(
                        text = "Add Marker",
                        fontSize = 15.sp,
                        //fontFamily = Poppins,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            //.padding(top = 30.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }

        if (dialogArrival) {
            AlertDialog(
                onDismissRequest = {
                    dialogArrival = false
                },
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Arrival",
                            style = TextStyle(Color.White),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(
                            value = valueNumberDialog,

                            onValueChange = {
                                valueNumberDialog = it
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.border(
                                width = 1.dp,
                                shape = RoundedCornerShape(15.dp),
                                color = Color.White
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {

                                }
                            ),
                        )

                    }
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(450.dp)
                    .height(175.dp)
                    .background(Color.Transparent),
                confirmButton = {
                    Column(modifier = Modifier.fillMaxWidth(1f)) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = {

                                dialogArrival = false
                            },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Color.White),

                            ) {
                            Text(
                                text = "Register arrival",
                                style = TextStyle(color = Color.White)
                            )
                        }

                    }
                }
            )

        }
        if (dialogMarker) {
            AlertDialog(
                onDismissRequest = {
                    dialogMarker = false
                },
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add Marker",
                            style = TextStyle(Color.White),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                            TextField(
                                value = valueLatDialog,

                                onValueChange = {
                                    valueLatDialog = it
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.Black,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.border(
                                    width = 1.dp,
                                    shape = RoundedCornerShape(15.dp),
                                    color = Color.White
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(
                                    onDone = {

                                    }
                                ),
                            )
                        TextField(
                            value = valueLongDialog,
                            onValueChange = {
                                valueLongDialog = it
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.border(
                                width = 1.dp,
                                shape = RoundedCornerShape(15.dp),
                                color = Color.White
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {

                                }
                            ),

                        )

                    }
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(450.dp)
                    .height(325.dp)
                    .background(Color.Transparent),
                confirmButton = {
                    Column(modifier = Modifier.fillMaxWidth(1f)) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = {

                                dialogMarker = false
                            },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Color.White),

                        ) {
                            Text(
                                text = "Save",
                                style = TextStyle(color = Color.White)
                            )
                        }

                        Spacer(modifier = Modifier.size(5.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = {

                                dialogMarker = false
                            },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Color.White),

                            ) {
                            Text(
                                text = "Save Current Position",
                                style = TextStyle(color = Color.White)
                            )
                        }
                    }
                }
            )
        }

        if (dialogWeather) {

        }

    }
}