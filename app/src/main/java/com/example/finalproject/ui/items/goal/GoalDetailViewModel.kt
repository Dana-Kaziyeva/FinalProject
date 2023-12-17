package com.example.finalproject.ui.items.goal

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class GoalDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository,
) : ViewModel() {

    private val goalId: Int = checkNotNull(savedStateHandle[GoalDetailsDestination.goalIdArg])

    val uiState: StateFlow<GoalDetailsUiState> =
        itemsRepository.getGoalStream(goalId)
            .filterNotNull()
            .map {
                GoalDetailsUiState(goalDetails = it.toGoalDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = GoalDetailsUiState()
            )

    suspend fun deleteItem() {
        itemsRepository.deleteGoal(uiState.value.goalDetails.toGoal())
    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class GoalDetailsUiState(
    val goalDetails: GoalDetails = GoalDetails()
)