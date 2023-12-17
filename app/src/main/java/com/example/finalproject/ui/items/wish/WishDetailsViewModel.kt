package com.example.finalproject.ui.items.wish

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.ui.items.goal.toGoal
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class WishDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private val wishId: Int = checkNotNull(savedStateHandle[WishDetailsDestination.wishIdArg])

    val uiState: StateFlow<WishDetailsUiState> =
        itemsRepository.getWishStream(wishId)
            .filterNotNull()
            .map {
                WishDetailsUiState(wishDetails = it.toWishDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = WishDetailsUiState()
            )
    suspend fun deleteItem() {
        itemsRepository.deleteWish(uiState.value.wishDetails.toWish())
    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class WishDetailsUiState(
    val wishDetails: WishDetails = WishDetails()
)
