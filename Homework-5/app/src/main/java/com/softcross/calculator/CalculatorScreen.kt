package com.softcross.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen() {
    val result = remember { mutableIntStateOf(0) }
    val process = remember { mutableStateOf("") }
    val key = remember { mutableStateOf("") }
    val oldValue = remember { mutableListOf<String>() }
    val listState = rememberLazyListState()

    LaunchedEffect(key1 = oldValue.size) {
        if (oldValue.size > 0) {
            listState.animateScrollToItem(oldValue.size - 1)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .height(100.dp),
                reverseLayout = true
            ) {
                items(oldValue.size) {
                    Text(
                        text = oldValue[it],
                        textAlign = TextAlign.End,
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
            Text(
                text = process.value,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Text(
                text = "= ${result.intValue}",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        Column {
            KeyRow(1) {
                key.value += it
                process.value += it
            }
            KeyRow(4) {
                key.value += it
                process.value += it
            }
            KeyRow(7) {
                key.value += it
                process.value += it
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        key.value += "0"
                        process.value += "0"
                    }, modifier = Modifier
                        .weight(0.3f)
                        .padding(8.dp)
                ) {
                    Text(text = "0")
                }
                Button(
                    onClick = {
                        result.intValue += if (key.value.isNotEmpty()) key.value.toInt() else 0
                        key.value = ""
                        process.value += " + "
                    }, modifier = Modifier
                        .weight(0.3f)
                        .padding(8.dp)
                ) {
                    Text(text = "+")
                }
                Button(
                    onClick = {
                        if (key.value.isNotEmpty()) {
                            result.intValue += key.value.toInt()
                            key.value = ""
                            if (!process.value.contains("+")) {
                                process.value += " + 0"
                            }
                            oldValue += process.value + " = " + result.intValue
                            process.value = ""
                            result.intValue = 0
                        } else {
                            process.value = " 0"
                            if (!process.value.contains("+")) {
                                process.value += " + 0"
                            }
                            oldValue += process.value + " = " + result.intValue
                            process.value = ""
                            result.intValue = 0
                        }
                    }, modifier = Modifier
                        .weight(0.3f)
                        .padding(8.dp)
                ) {
                    Text(text = "=")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        key.value = ""
                        process.value = ""
                        result.intValue = 0
                    }, modifier = Modifier
                        .weight(0.6f)
                        .padding(8.dp)
                ) {
                    Text(text = "Reset")
                }
                Button(
                    onClick = {
                        if (key.value.isNotEmpty()) {
                            key.value = key.value.dropLast(1)
                            process.value = process.value.dropLast(1)
                        }
                    }, modifier = Modifier
                        .weight(0.3f)
                        .padding(8.dp)
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }
}

@Composable
fun KeyRow(firstKey: Int, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { onClick("$firstKey") }, modifier = Modifier
                .weight(0.3f)
                .padding(8.dp)
        ) {
            Text(text = "$firstKey")
        }
        Button(
            onClick = { onClick("${firstKey + 1}") }, modifier = Modifier
                .weight(0.3f)
                .padding(8.dp)
        ) {
            Text(text = "${firstKey + 1}")
        }
        Button(
            onClick = { onClick("${firstKey + 2}") }, modifier = Modifier
                .weight(0.3f)
                .padding(8.dp)
        ) {
            Text(text = "${firstKey + 2}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen()
}