package com.example.finalproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.finalproject.ui.home.GoalHomeDestination
import com.example.finalproject.ui.home.GoalHomeScreen
import com.example.finalproject.ui.home.ItemHomeDestination
import com.example.finalproject.ui.home.ItemHomeScreen
import com.example.finalproject.ui.home.UserHomeDestination
import com.example.finalproject.ui.home.UserHomeScreen
import com.example.finalproject.ui.home.WishHomeDestination
import com.example.finalproject.ui.home.WishHomeScreen
import com.example.finalproject.ui.items.goal.GoalDetailsDestination
import com.example.finalproject.ui.items.goal.GoalDetailsScreen
import com.example.finalproject.ui.items.goal.GoalEditDestination
import com.example.finalproject.ui.items.goal.GoalEditScreen
import com.example.finalproject.ui.items.goal.GoalEntryDestination
import com.example.finalproject.ui.items.goal.GoalEntryScreen
import com.example.finalproject.ui.items.item.ItemDetailsDestination
import com.example.finalproject.ui.items.item.ItemDetailsScreen
import com.example.finalproject.ui.items.item.ItemEditDestination
import com.example.finalproject.ui.items.item.ItemEditScreen
import com.example.finalproject.ui.items.item.ItemEntryDestination
import com.example.finalproject.ui.items.item.ItemEntryScreen
import com.example.finalproject.ui.items.user.UserDetailsDestination
import com.example.finalproject.ui.items.user.UserDetailsScreen
import com.example.finalproject.ui.items.user.UserEditDestination
import com.example.finalproject.ui.items.user.UserEditScreen
import com.example.finalproject.ui.items.user.UserEntryDestination
import com.example.finalproject.ui.items.user.UserEntryScreen
import com.example.finalproject.ui.items.wish.WishDetailsDestination
import com.example.finalproject.ui.items.wish.WishDetailsScreen
import com.example.finalproject.ui.items.wish.WishEditDestination
import com.example.finalproject.ui.items.wish.WishEditScreen
import com.example.finalproject.ui.items.wish.WishEntryDestination
import com.example.finalproject.ui.items.wish.WishEntryScreen
import com.example.finalproject.ui.screens.HomePage
import com.example.finalproject.ui.screens.WelcomePage
import kotlin.random.Random

@Composable
fun NavGraph(navController: NavHostController,
             modifier: Modifier = Modifier,) {
    NavHost(
        navController = navController,
        startDestination = ItemHomeDestination.route,
        modifier = modifier
//        startDestination = when (WelcomePage().getVisited()) {
//            false -> "WelcomePage"
//            else -> "HomePage"
//        }
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
//        composable(route = MenuBar.WishList.route) {
//            WishListPage()
//        }
//        composable(route = MenuBar.GoalList.route) {
//            GoalListPage().GoalListPageLayout()
//        }
//        composable(route = MenuBar.ToDoList.route) {
//            ToDoListPage()
//        }
//        composable(route = MenuBar.AddItem.route) {
//            HomePage().HomePageLayout(WelcomePage(), Random.nextInt(1,24))
//        }
//        composable("Settings") {
//           Settings()
//        }
//        composable(MenuBar.ToDoList.route) {
            composable(route = ItemHomeDestination.route) {
            ItemHomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
//        composable(MenuBar.WishList.route) {
            composable(route = WishHomeDestination.route) {
            WishHomeScreen(
                navigateToWishEntry = { navController.navigate(WishEntryDestination.route) },
                navigateToWishUpdate = {
                    navController.navigate("${WishDetailsDestination.route}/${it}")
                }
            )
        }
//        composable(MenuBar.GoalList.route) {
            composable(route = GoalHomeDestination.route) {
            GoalHomeScreen(
                navigateToGoalEntry = { navController.navigate(GoalEntryDestination.route) },
                navigateToGoalUpdate = {
                    navController.navigate("${GoalDetailsDestination.route}/${it}")
                }
            )
        }
//        composable(MenuBar.AddItem.route) {
            composable(route = UserHomeDestination.route) {
            UserHomeScreen(
                navigateToUserEntry = { navController.navigate(UserEntryDestination.route) },
                navigateToUserUpdate = {
                    navController.navigate("${UserDetailsDestination.route}/${it}")
                }
            )
        }

        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(route = WishEntryDestination.route) {
            WishEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(route = GoalEntryDestination.route) {
            GoalEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(route = UserEntryDestination.route) {
            UserEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }

        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = WishDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(WishDetailsDestination.wishIdArg) {
                type = NavType.IntType
            })
        ) {
            WishDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${WishEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = GoalDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(GoalDetailsDestination.goalIdArg) {
                type = NavType.IntType
            })
        ) {
            GoalDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${GoalEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = UserDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(UserDetailsDestination.userIdArg) {
                type = NavType.IntType
            })
        ) {
            UserDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${UserEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = WishEditDestination.routeWithArgs,
            arguments = listOf(navArgument(WishEditDestination.wishIdArg) {
                type = NavType.IntType
            })
        ) {
            WishEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = GoalEditDestination.routeWithArgs,
            arguments = listOf(navArgument(GoalEditDestination.goalIdArg) {
                type = NavType.IntType
            })
        ) {
            GoalEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = UserEditDestination.routeWithArgs,
            arguments = listOf(navArgument(UserEditDestination.userIdArg) {
                type = NavType.IntType
            })
        ) {
            UserEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}