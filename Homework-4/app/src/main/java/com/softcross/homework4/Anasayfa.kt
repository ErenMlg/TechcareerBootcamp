package com.softcross.homework4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Anasayfa(
    onClickA: () -> Unit,
    onClickX: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Anasayfa", fontSize = 32.sp)
        Button(onClick = { onClickA() }) {
            Text("A Sayfası")
        }
        Button(onClick = { onClickX() }) {
            Text("X Sayfası")
        }
    }
}