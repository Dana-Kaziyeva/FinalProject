package com.example.finalproject.ui.items.user

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.ui.items.item.ItemDetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class UserDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository,
) : ViewModel() {

    private val userId: Int = checkNotNull(savedStateHandle[UserDetailsDestination.userIdArg])

    val uiState: StateFlow<UserDetailsUiState> =
        itemsRepository.getUserStream(userId)
            .filterNotNull()
            .map {
                UserDetailsUiState(userDetails = it.toUserDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = UserDetailsUiState()
            )
    suspend fun deleteItem() {
        itemsRepository.deleteUser(uiState.value.userDetails.toUser())
    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class UserDetailsUiState(
    val userDetails: UserDetails = UserDetails()
)
