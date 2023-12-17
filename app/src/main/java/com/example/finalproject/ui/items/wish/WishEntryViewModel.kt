package com.example.finalproject.ui.items.wish

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.data.Wishes

class WishEntryViewModel (private val itemsRepository: ItemsRepository) : ViewModel() {

    var wishUiState by mutableStateOf(WishUiState())
        private set

    fun updateWishUiState(wishDetails: WishDetails) {
        wishUiState =
            WishUiState(wishDetails = wishDetails, isEntryValid = validateWishInput(wishDetails))
    }

    suspend fun saveWish() {
        if (validateWishInput()) {
            itemsRepository.insertWish(wishUiState.wishDetails.toWish())
        }
    }

    private fun validateWishInput(uiState: WishDetails = wishUiState.wishDetails): Boolean {
        return with(uiState) {
            desc.isNotBlank() && title.isNotBlank()
        }
    }
}

data class WishUiState(
    val wishDetails: WishDetails = WishDetails(),
    val isEntryValid: Boolean = false
)
data class WishDetails(
    val id:Int =0,
    val title:String = "",
    val desc:String = "",
    val link:String = "",
    var check:Boolean =false
)
fun WishDetails.toWish(): Wishes = Wishes(
    id =id,
    title =title,
    desc= desc,
    link= link ?:"",
    check=check
)
fun Wishes.toItemUiState(isEntryValid: Boolean = false): WishUiState = WishUiState(
    wishDetails = this.toWishDetails(),
    isEntryValid = isEntryValid
)
fun Wishes.toWishDetails(): WishDetails = WishDetails(
    id = id,
    title =title,
    desc = desc,
    link = link,
    check =check
)