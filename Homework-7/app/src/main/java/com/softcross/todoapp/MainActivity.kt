package com.softcross.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.softcross.todoapp.navigation.AddToDo
import com.softcross.todoapp.navigation.EditToDo
import com.softcross.todoapp.navigation.Home
import com.softcross.todoapp.navigation.ToDoNavHost
import com.softcross.todoapp.presentation.home.HomeScreen
import com.softcross.todoapp.presentation.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            var fabVisible by remember { mutableStateOf(false) }
            val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
            LaunchedEffect(currentBackStackEntry) {
                fabVisible = currentBackStackEntry?.destination?.route == Home.route
            }
            ToDoAppTheme {
                Scaffold(
                    containerColor = Color.White,
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        if (fabVisible) {
                            FloatingActionButton(
                                onClick = { navHostController.navigate(AddToDo.route) },
                                containerColor = Color(
                                    0xFF283593
                                )
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_add),
                                    contentDescription = "Add",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    ToDoNavHost(
                        navHostController = navHostController,
                        modifier = Modifier
                            .padding(innerPadding)
                            .imePadding()
                    )
                }
            }
        }
    }
}

