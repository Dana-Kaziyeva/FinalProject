package com.example.finalproject.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.sharp.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.finalproject.ui.home.GoalHomeDestination
import com.example.finalproject.ui.home.ItemHomeDestination
import com.example.finalproject.ui.home.UserHomeDestination
import com.example.finalproject.ui.home.WishHomeDestination
import com.example.finalproject.ui.items.goal.GoalDetailsDestination
import com.example.finalproject.ui.items.item.ItemDetailsDestination
import com.example.finalproject.ui.items.wish.WishDetailsDestination

sealed class MenuBar(
    val route:String,
    val title: String,
    val icon: ImageVector
) {
    object WishList : MenuBar(
        route = WishHomeDestination.route,
        title = "WishList",
        icon = Icons.Default.Star
    )

    object GoalList : MenuBar(
        route = GoalHomeDestination.route,
        title = "GoalList",
        icon = Icons.Rounded.Place
    )

    object AddItem : MenuBar(
        route = UserHomeDestination.route,
        title = "Add item",
        icon = Icons.Rounded.AddCircle
    )

    object ToDoList : MenuBar(
        route = ItemHomeDestination.route,
        title = "ToDoList",
        icon = Icons.Sharp.List
    )
    object Home : MenuBar(
        route = "HomePage",
        title = "Home",
        icon = Icons.Default.Home
    )
}


