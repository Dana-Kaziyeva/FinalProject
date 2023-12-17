package com.example.finalproject.ui.items.goal

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

class GoalEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    var goalUiState by mutableStateOf(GoalUiState())
        private set

    private val goalId: Int = checkNotNull(savedStateHandle[GoalEditDestination.goalIdArg])

    init {
        viewModelScope.launch {
            goalUiState = itemsRepository.getGoalStream(goalId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    suspend fun updateItem() {
        if (validateGoalInput(goalUiState.goalDetails)) {
            itemsRepository.updateGoal(goalUiState.goalDetails.toGoal())
        }
    }

    fun updateUiState(goalDetails: GoalDetails) {
        goalUiState =
            GoalUiState(goalDetails = goalDetails, isEntryValid = validateGoalInput(goalDetails))
    }
    private fun validateGoalInput(uiState: GoalDetails = goalUiState.goalDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && date.isNotBlank()
        }
    }
}
