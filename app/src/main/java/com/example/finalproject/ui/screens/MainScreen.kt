package com.example.finalproject.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.NavGraph
import com.example.finalproject.ui.theme.HomePage_Color

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val welcome = WelcomePage()
    val home = HomePage()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)},
        topBar = {

        }
    ) {
       NavGraph(navController = navController, welcome = welcome, home = home)
    }
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