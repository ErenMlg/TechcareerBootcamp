package com.softcross.todoapp.presentation.add

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.softcross.todoapp.domain.model.ToDo

@Composable
fun AddToDoScreen(
    modifier: Modifier = Modifier,
    viewModel: AddToDoViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    var toDoName by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add To Do", modifier = Modifier
                .padding(8.dp)
                .weight(0.4f)
        )
        Column(modifier = Modifier.weight(0.5f)) {
            TextField(
                placeholder = { Text(text = "Enter To Do Name") },
                value = toDoName,
                onValueChange = { toDoName = it },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTextColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color(0x33283593),
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
            )
            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF283593),
                ),
                onClick = {
                    if (toDoName.isNotEmpty()) {
                        viewModel.addToDo(ToDo(0, toDoName))
                        onBack()
                    } else {
                        Toast.makeText(
                            context,
                            "Please enter a to do name",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(text = "Add")
            }
        }
    }
}
