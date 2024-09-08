package com.softcross.todoapp.presentation.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.softcross.todoapp.R
import com.softcross.todoapp.common.ScreenState
import com.softcross.todoapp.domain.model.ToDo

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onEditClick: (ToDo) -> Unit
) {
    val todoState = viewModel.todoState.value
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "To Do List", modifier = Modifier.padding(8.dp))
        when (todoState) {
            is ScreenState.Error -> Text(text = todoState.message)
            ScreenState.Loading -> CircularProgressIndicator()
            is ScreenState.Success -> {
                HomeScreenContent(
                    modifier,
                    todoState.data,
                    onEditClick,
                    viewModel::deleteToDo,
                    viewModel::search
                )
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    todoList: List<ToDo>,
    onEditClick: (ToDo) -> Unit,
    onDeleteClick: (ToDo) -> Unit,
    search: (String) -> Unit
) {
    var searchKey by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = searchKey) {
        search(searchKey)
    }

    TextField(
        placeholder = { Text(text = "Enter Search Key") },
        value = searchKey,
        onValueChange = { searchKey = it },
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
            .fillMaxWidth()
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
    )
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(todoList.size, key = { todoList[it].id }) { index ->
            ToDoItem(toDo = todoList[index], onEditClick, onDeleteClick)
        }
    }
}

@Composable
fun ToDoItem(toDo: ToDo, onEditClick: (ToDo) -> Unit, onDeleteClick: (ToDo) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .clip(CircleShape)
                .weight(0.1f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF283593))
        ) {
            Text(
                text = toDo.id.toString(),
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Text(
            text = toDo.name,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(0.8f)
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_edit),
            contentDescription = "Edit",
            tint = Color(0xFF283593),
            modifier = Modifier
                .padding(end = 8.dp)
                .weight(0.1f)
                .clickable {
                    onEditClick(toDo)
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_delete),
            contentDescription = "Delete",
            tint = Color(0xFF283593),
            modifier = Modifier
                .padding(end = 8.dp)
                .weight(0.1f)
                .clickable {
                    onDeleteClick(toDo)
                }
        )
    }
}
