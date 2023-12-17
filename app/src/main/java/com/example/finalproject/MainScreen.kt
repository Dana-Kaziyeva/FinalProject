package com.example.finalproject

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.navigation.NavGraph
import com.example.finalproject.ui.navigation.MenuBar
import com.example.finalproject.ui.screens.WelcomePage
import com.example.finalproject.ui.theme.HomePage_Color
import com.example.finalproject.ui.theme.fontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
//        topBar = { when(navBackStackEntry?.destination?.route) {
//            "HomePage"     -> TopHomeBar(navController = navController, "Profile")
//        }
//        },
        bottomBar = { if (navBackStackEntry?.destination?.route != "WelcomePage")
            BottomBar(navController = navController) }
    )
    {
        NavGraph(navController = navController)
    }
//    NavGraph(navController = navController)
//
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopHomeBar(navController: NavController, name: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(color = HomePage_Color)
        .padding(17.dp), horizontalArrangement = Arrangement.SpaceAround
    )
    {

        var name = WelcomePage().getName()
        Text(
            text = "Hi, $name!",
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = fontFamily,
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
        )
        IconButton(onClick = { navController.navigate("Settings") }) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile icon",
                modifier = Modifier.size(49.dp),
                tint = Color.White
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopListBar(navController: NavController, screenTitle: String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(color = HomePage_Color)
        .padding(17.dp)){
        IconButton(onClick = { navController.navigate("Settings") }) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile icon",
                modifier = Modifier.size(49.dp),
                tint = Color.White
            )
        }
        Text(
            text = screenTitle,
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = fontFamily,
            color = Color.White,
            fontSize = 32.sp
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon",
                modifier = Modifier.size(49.dp),
                tint = Color.White
            )
        }
        }
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
                    contentDescription = "Profile icon",
                    modifier = Modifier.size(49.dp),
                    tint = Color.White
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
                    contentDescription = "Search icon",
                    modifier = Modifier.size(49.dp),
                    tint = Color.White
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
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
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
                            Text(text = screen.title, color = Color.White)
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
                selectedContentColor = Color.Blue,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                )
        }
}
}