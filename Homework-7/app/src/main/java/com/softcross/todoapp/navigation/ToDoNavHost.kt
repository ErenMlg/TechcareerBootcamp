package com.softcross.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.softcross.todoapp.presentation.add.AddToDoScreen
import com.softcross.todoapp.presentation.edit.EditToDoScreen
import com.softcross.todoapp.presentation.home.HomeScreen

@Composable
fun ToDoNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navController = navHostController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(modifier = modifier) { toDo ->
                navHostController.navigate("${EditToDo.route}/${toDo.id}/${toDo.name}")
            }
        }
        composable(EditToDo.routeWithArgs, arguments = EditToDo.arguments) {
            EditToDoScreen(
                modifier = modifier,
                onBack = {
                    navHostController.navigate(Home.route) {
                        popUpTo(Home.route) {
                            inclusive = true
                        }
                    }
                },
                selectedToDoName = it.arguments?.getString("toDoName") ?: "",
                selectedToDoID = it.arguments?.getInt("toDoId") ?: 0,
            )
        }
        composable(AddToDo.route) {
            AddToDoScreen(modifier = modifier, onBack = {
                navHostController.navigate(Home.route) {
                    popUpTo(Home.route) {
                        inclusive = true
                    }
                }
            })
        }
    }
}