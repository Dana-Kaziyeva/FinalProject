package com.example.finalproject.ui.items.wish

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.finalproject.data.ItemsRepository
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class WishEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : ViewModel() {


    var wishUiState by mutableStateOf(WishUiState())
        private set


 private val wishId: Int = checkNotNull(savedStateHandle[WishEditDestination.wishIdArg])

    init {
        viewModelScope.launch {
            wishUiState = itemsRepository.getWishStream(wishId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    suspend fun updateItem() {
        if (validateWishInput(wishUiState.wishDetails)) {
            itemsRepository.updateWish(wishUiState.wishDetails.toWish())
        }
    }

    fun updateUiState(wishDetails: WishDetails) {
        wishUiState =
            WishUiState(wishDetails = wishDetails, isEntryValid = validateWishInput(wishDetails))
    }

    private fun validateWishInput(uiState: WishDetails = wishUiState.wishDetails): Boolean {
        return with(uiState) {
            desc.isNotBlank() && title.isNotBlank()
        }
    }

}