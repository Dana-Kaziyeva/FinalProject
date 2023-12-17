package com.example.finalproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.Goals
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.data.ToDoList
import com.example.finalproject.data.User
import com.example.finalproject.data.Wishes
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(itemsRepository: ItemsRepository) : ViewModel() {

    val itemHomeUiState: StateFlow<ItemHomeUiState> =
        itemsRepository.getAllItemsStream().map { ItemHomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemHomeUiState()
            )
    val wishHomeUiState: StateFlow<WishHomeUiState> =
        itemsRepository.getAllWishesStream().map { WishHomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = WishHomeUiState()
            )
    val goalHomeUiState: StateFlow<GoalHomeUiState> =
        itemsRepository.getAllGoalsStream().map { GoalHomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = GoalHomeUiState()
            )
    val userHomeUiState: StateFlow<UserHomeUiState> =
        itemsRepository.getAllUsersStream().map { UserHomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = UserHomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class ItemHomeUiState(val itemList: List<ToDoList> = listOf())
data class WishHomeUiState(val itemList: List<Wishes> = listOf())
data class GoalHomeUiState(val itemList: List<Goals> = listOf())
data class UserHomeUiState(val itemList: List<User> = listOf())
