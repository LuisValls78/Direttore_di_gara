package com.luisvalls.direttoredigara.screens.Amministratore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.luisvalls.direttoredigara.navigation.Screen

@Composable
fun MenuGestion(
    navController: NavController,

    ) {
    Column() {
        Text(
            text = "MENU GESTION",
            fontSize = 15.sp,
            //fontFamily = Poppins,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(8.dp))

        Button(
            onClick = {
                navController.navigate(route = Screen.ScreenViewEvents.route)

            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
            modifier = Modifier.width(160.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, Color.Black),
        ) {
            Text(
                text = "Gestionar eventos",
                fontSize = 15.sp,
                //fontFamily = Poppins,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Button(
            onClick = {
                navController.navigate(route = Screen.AddDispositive.route)

            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
            modifier = Modifier.width(160.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, Color.Black),
        ) {
            Text(
                text = "Gestionar dispositivos",
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