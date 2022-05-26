package com.luisvalls.direttoredigara.screens.Utente

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuUsers(){
    Text(
        text = "MENU USERS",
        fontSize = 15.sp,
        //fontFamily = Poppins,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
    )
}