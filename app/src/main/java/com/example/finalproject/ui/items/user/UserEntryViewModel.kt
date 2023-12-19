package com.example.finalproject.ui.items.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.ItemsRepository
import com.example.finalproject.data.User

class UserEntryViewModel (private val itemsRepository: ItemsRepository) : ViewModel() {

    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUserUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails)
    }
//    fun updateUserCheck(userDetails: UserDetails){
//        userUiState = UserUiState(userDetails.check=true)
//    }
    suspend fun saveUser() {
        itemsRepository.insertUser(userUiState.userDetails.toUser())

    }
}
data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)
data class UserDetails(
    val id:Int =0,
    val name:String = "",
    var age:Int =5,
//    var check:Boolean =false
)
fun UserDetails.toUser(): User = User(
    id =id,
    name=name ?:"Ainalaiyn",
    age=age ?:5,
//    check= check?:false
)
fun User.toItemUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)
fun User.toUserDetails(): UserDetails = UserDetails(
    id = id,
    name = name,
    age =age
)