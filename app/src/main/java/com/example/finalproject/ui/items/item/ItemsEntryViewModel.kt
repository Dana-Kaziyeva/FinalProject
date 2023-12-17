package com.example.finalproject.ui.items.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
//import com.example.finalproject.data.Goals
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.data.ToDoList
//import com.example.finalproject.data.User
//import com.example.finalproject.data.Wishes

class ItemsEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set
//    var wishUiState by mutableStateOf(WishUiState())
//        private set
//    var goalUiState by mutableStateOf(GoalUiState())
//        private set
//    var userUiState by mutableStateOf(UserUiState())
//        private set


    fun updateItemUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateItemInput(itemDetails))
    }
//    fun updateWishUiState(wishDetails: WishDetails) {
//        wishUiState =
//            WishUiState(wishDetails = wishDetails, isEntryValid = validateWishInput(wishDetails))
//    }
//    fun updateGoalUiState(goalDetails: GoalDetails) {
//        goalUiState =
//            GoalUiState(goalDetails = goalDetails, isEntryValid = validateGoalInput(goalDetails))
//    }
//    fun updateUserUiState(userDetails: UserDetails) {
//        userUiState =
//            UserUiState(userDetails = userDetails)
//    }


    suspend fun saveItem() {
        if (validateItemInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }
//    suspend fun saveWish() {
//        if (validateWishInput()) {
//            itemsRepository.insertWish(wishUiState.wishDetails.toWish())
//        }
//    }
//    suspend fun saveGoal() {
//        if (validateGoalInput()) {
//            itemsRepository.insertGoal(goalUiState.goalDetails.toGoal())
//        }
//    }
//    suspend fun saveUser() {
//            itemsRepository.insertUser(userUiState.userDetails.toUser())
//
//    }
    private fun validateItemInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            desc.isNotBlank()
        }
    }
//    private fun validateWishInput(uiState: WishDetails = wishUiState.wishDetails): Boolean {
//        return with(uiState) {
//            desc.isNotBlank() && title.isNotBlank()
//        }
//    }
//    private fun validateGoalInput(uiState: GoalDetails = goalUiState.goalDetails): Boolean {
//        return with(uiState) {
//            title.isNotBlank() && date.isNotBlank()
//        }
//    }
}
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)
//data class WishUiState(
//    val wishDetails: WishDetails = WishDetails(),
//    val isEntryValid: Boolean = false
//)
//data class GoalUiState(
//    val goalDetails: GoalDetails = GoalDetails(),
//    val isEntryValid: Boolean = false
//)
//data class UserUiState(
//    val userDetails: UserDetails = UserDetails(),
//    val isEntryValid: Boolean = false
//)
data class ItemDetails(
    val id:Int =0,
    val desc:String = "",
    var check:Boolean =false
)
//data class WishDetails(
//    val id:Int =0,
//    val title:String = "",
//    val desc:String = "",
//    val link:String = "",
//    var check:Boolean =false
//)
//data class GoalDetails(
//    val id:Int =0,
//    val title:String = "",
//    val date:String = "",
//    var check:Boolean =false
//)
//data class UserDetails(
//    val id:Int =0,
//    val name:String = "",
//    var age:Int =5
//)

fun ItemDetails.toItem(): ToDoList = ToDoList(
    id =id,
    desc = desc,
    check = check
)
//fun WishDetails.toWish(): Wishes = Wishes(
//    id =id,
//    title =title,
//    desc= desc,
//    link= link ?:"",
//    check=check
//)
//fun GoalDetails.toGoal(): Goals = Goals(
//    id = id,
//    title =title,
//    date=date,
//    check=check
//)
//fun UserDetails.toUser(): User = User(
//    id =id,
//    name=name ?:"Ainalaiyn",
//    age=age ?:5
//)
fun ToDoList.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)
//fun Wishes.toWishUiState(isEntryValid: Boolean = false): WishUiState = WishUiState(
//    wishDetails = this.toWishDetails(),
//    isEntryValid = isEntryValid
//)
//fun Goals.toItemUiState(isEntryValid: Boolean = false): GoalUiState = GoalUiState(
//    goalDetails = this.toGoalDetails(),
//    isEntryValid = isEntryValid
//)
//fun User.toItemUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
//    userDetails = this.toUserDetails(),
//    isEntryValid = isEntryValid
//)
fun ToDoList.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    desc = desc,
    check =check
)
//fun Wishes.toWishDetails(): WishDetails = WishDetails(
//    id = id,
//    title =title,
//    desc = desc,
//    link = link,
//    check =check
//)
//fun Goals.toGoalDetails(): GoalDetails = GoalDetails(
//    id = id,
//    title= title,
//    date = date,
//    check =check
//)
//fun User.toUserDetails(): UserDetails = UserDetails(
//    id = id,
//    name = name,
//    age =age
//)