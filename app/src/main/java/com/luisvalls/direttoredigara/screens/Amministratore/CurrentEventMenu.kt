package com.luisvalls.direttoredigara.screens.Amministratore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.luisvalls.direttoredigara.navigation.Screen

@Composable
fun CurrentEventMenu(navController: NavController) {
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
            title = { Text(text = "Current Event") },
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
        , actions = {
                IconButton(onClick = {

                }) {
                    Icon(
                        Icons.Default.WbCloudy,
                        "icono clima",
                        tint = Color.White,
                        //modifier = Modifier.padding(horizontal = 5.dp)
                    )

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
        ) {}
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Event: Valencia CUP",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()
                )

            Spacer(modifier = Modifier.size(500.dp))

            Row() {

                Button(
                    onClick = {
                        navController.navigate(route = Screen.ListDispositives.route)

                    },
                    // shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                    modifier = Modifier.width(160.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Text(
                        text = "Registrar llegada",
                        fontSize = 15.sp,
                        //fontFamily = Poppins,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.size(50.dp))

                Button(
                    onClick = {
                        navController.navigate(route = Screen.ListDispositives.route)

                    },
                    // shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
                    modifier = Modifier.width(160.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.Black),
                ) {
                    Text(
                        text = "Añadir baliza",
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