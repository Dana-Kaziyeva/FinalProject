package com.example.finalproject.ui.items.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.ItemsRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class UserEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository

) : ViewModel() {

  var userUiState by mutableStateOf(UserUiState())
        private set

 private val userId: Int = checkNotNull(savedStateHandle[UserEditDestination.userIdArg])

    init {
        viewModelScope.launch {
            userUiState = itemsRepository.getUserStream(userId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }
    suspend fun updateItem() {
        itemsRepository.updateUser(userUiState.userDetails.toUser())

    }
    fun updateUiState(itemDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = itemDetails)
    }


}
