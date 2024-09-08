package com.softcross.todoapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route: String
}

object Home : Destination {
    override val route = "home"
}

object EditToDo : Destination {
    override val route = "edit_todo"
    val routeWithArgs = "edit_todo/{toDoId}/{toDoName}"
    val arguments = listOf(
        navArgument("toDoId") {
            type = NavType.IntType
            nullable = false
        },
        navArgument("toDoName") {
            type = NavType.StringType
            nullable = false
        },
    )
}

object AddToDo : Destination {
    override val route = "add_todo"
}