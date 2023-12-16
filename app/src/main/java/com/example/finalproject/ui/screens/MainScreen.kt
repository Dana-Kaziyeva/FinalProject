package com.example.finalproject.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.sharp.List
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.NavGraph
import com.example.finalproject.ui.theme.HomePage_Color

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val welcome = WelcomePage()
//    val home = HomePage()
//    val goal = GoalListPage()


    Scaffold(
        topBar = { when(navBackStackEntry?.destination?.route) {
            "WishListPage" -> TopListBar(navController = navController, "WishList")
            "GoalListPage" -> TopListBar(navController = navController, "GoalList")
            "ToDoListPage" -> TopListBar(navController = navController, "ToDoList")
            "HomePage"     -> TopHomeBar(navController = navController, "Profile")

        }
        },
        bottomBar = { if (navBackStackEntry?.destination?.route != "WelcomePage") BottomBar(navController = navController) }
    )
    {
        NavGraph(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopHomeBar(navController: NavController, name: String) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer, // Use backgroundColor instead of colors
        contentColor = MaterialTheme.colorScheme.primary, // Use contentColor instead of titleContentColor
        title = {
            Text(
                text = "Hi, $name ",
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile icon"
                )
            }

        },

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopListBar(navController: NavController, screenTitle: String) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = HomePage_Color,
                titleContentColor = Color.White,
            ),
            title = {
                Text(
                    text = screenTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("Settings") }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Profile icon"
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon"
                    )
                }
            },
        )
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopListItemBar(navController: NavController, screenTitle: String) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = HomePage_Color,
            titleContentColor = Color.White,
        ),
        title = {
            Text(
                text = screenTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile icon"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector =
                        when(screenTitle){
                            "WishList" -> Icons.Default.Star
                            "GoalList" -> Icons.Rounded.Place
                             else -> Icons.Sharp.List
                        }
                    ,
                    contentDescription = "Search icon"
                )
            }
        },
    )
}

@Composable
fun BottomBar(navController: NavController){
    val bottomScreens = listOf(
        MenuBar.WishList,
        MenuBar.GoalList,
        MenuBar.AddItem,
        MenuBar.ToDoList,
        MenuBar.Home
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = HomePage_Color,
        elevation = 5.dp){
        bottomScreens.forEach { screen ->
            val selected = screen.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(screen.route)
                },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (selected) {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = "icon",
                                tint = Color.White,
                                modifier = Modifier.alpha(1.0f)
                            )
                            Text(text = screen.title)
                        }
                        else
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = "icon",
                                tint = Color.White,
                                modifier = Modifier.alpha(1.0f)
                            )

                    }
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Green,

                )
        }
}
}