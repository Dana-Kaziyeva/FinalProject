package com.example.finalproject.ui.items.goal

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.R
import com.example.finalproject.ui.AppViewModelProvider
import com.example.finalproject.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

object GoalEditDestination : NavigationDestination {
    override val route = "goal_edit"
    override val titleRes = R.string.edit_goal_title
    const val goalIdArg = "goalId"
    val routeWithArgs = "$route/{$goalIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: GoalEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    GoalEntryBody(
        goalUiState = viewModel.goalUiState,
        onGoalValueChange = viewModel::updateUiState,
        onSaveClick = {
            coroutineScope.launch {
                viewModel.updateItem()
                navigateBack()
            }
        },
        modifier = Modifier.padding()
    )
}