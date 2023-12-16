package com.example.finalproject.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalproject.ui.screens.GoalListPage
import com.example.finalproject.ui.screens.HomePage
import com.example.finalproject.ui.screens.MenuBar
import com.example.finalproject.ui.screens.Settings
import com.example.finalproject.ui.screens.ToDoListPage
import com.example.finalproject.ui.screens.WelcomePage
import com.example.finalproject.ui.screens.WishListPage
import kotlin.random.Random

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = when (WelcomePage().getVisited()) {
            false -> "WelcomePage"
            else -> "HomePage"
        }
    )
    {
        composable("WelcomePage") {
            WelcomePage().WelcomePageLayout(
                navigateToHomePage = { navController.navigate("HomePage") }
            )
        }
        composable("HomePage") {
            HomePage().HomePageLayout(WelcomePage(), Random.nextInt(1,24))
        }
        composable(route = MenuBar.WishList.route) {
            WishListPage()
        }
        composable(route = MenuBar.GoalList.route) {
            GoalListPage().GoalListPageLayout()
        }
        composable(route = MenuBar.ToDoList.route) {
            ToDoListPage()
        }
        composable(route = MenuBar.AddItem.route) {
            HomePage().HomePageLayout(WelcomePage(), Random.nextInt(1,24))
        }
        composable("Settings") {
           Settings()
        }
    }
}