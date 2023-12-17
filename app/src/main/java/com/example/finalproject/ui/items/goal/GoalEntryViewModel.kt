package com.example.finalproject.ui.items.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.Goals
import com.example.finalproject.data.ItemsRepository

class GoalEntryViewModel (private val itemsRepository: ItemsRepository) : ViewModel() {

    var goalUiState by mutableStateOf(GoalUiState())
        private set

    fun updateGoalUiState(goalDetails: GoalDetails) {
        goalUiState =
            GoalUiState(goalDetails = goalDetails, isEntryValid = validateGoalInput(goalDetails))
    }

    suspend fun saveGoal() {
        if (validateGoalInput()) {
            itemsRepository.insertGoal(goalUiState.goalDetails.toGoal())
        }
    }

    private fun validateGoalInput(uiState: GoalDetails = goalUiState.goalDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && date.isNotBlank()
        }
    }
}
data class GoalUiState(
    val goalDetails: GoalDetails = GoalDetails(),
    val isEntryValid: Boolean = false
)
data class GoalDetails(
    val id:Int =0,
    val title:String = "",
    val date:String = "",
    var check:Boolean =false
)
fun GoalDetails.toGoal(): Goals = Goals(
    id = id,
    title =title,
    date=date,
    check=check
)
fun Goals.toItemUiState(isEntryValid: Boolean = false): GoalUiState = GoalUiState(
    goalDetails = this.toGoalDetails(),
    isEntryValid = isEntryValid
)
fun Goals.toGoalDetails(): GoalDetails = GoalDetails(
    id = id,
    title= title,
    date = date,
    check =check
)