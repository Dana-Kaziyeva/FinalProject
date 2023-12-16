package com.example.finalproject.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalproject.ui.screens.GoalListPage
import com.example.finalproject.ui.screens.HomePage
import com.example.finalproject.ui.screens.MenuBar
import com.example.finalproject.ui.screens.ToDoListPage
import com.example.finalproject.ui.screens.WelcomePage
import com.example.finalproject.ui.screens.WishListPage
import kotlin.random.Random

@Composable
fun NavGraph(navController: NavHostController, welcome: WelcomePage, home: HomePage) {
    NavHost(
        navController = navController,
        startDestination = when (welcome.getVisited()) {
            false -> "WelcomePage"
            else -> "HomePage"
        }
    )
    {
        composable("WelcomePage") {
            welcome.WelcomePageLayout(
                navigateToHomePage = { navController.navigate("HomePage") },
            )
        }
        composable("HomePage") {
            home.HomePageLayout(welcome, Random.nextInt(1,24))
        }
        composable(route = MenuBar.WishList.route) {
            WishListPage()
        }
        composable(route = MenuBar.GoalList.route) {
            GoalListPage()
        }
        composable(route = MenuBar.ToDoList.route) {
            ToDoListPage()
        }
        composable(route = MenuBar.AddItem.route) {
            home.HomePageLayout(welcome, Random.nextInt(1,24))
        }
    }
}