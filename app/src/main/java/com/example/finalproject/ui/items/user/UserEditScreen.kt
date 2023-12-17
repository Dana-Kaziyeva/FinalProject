package com.example.finalproject.ui.items.user

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.R
import com.example.finalproject.ui.AppViewModelProvider
import com.example.finalproject.ui.items.item.ItemsEditViewModel
import com.example.finalproject.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

object UserEditDestination : NavigationDestination {
    override val route = "user_edit"
    override val titleRes = R.string.edit_user_title
    const val userIdArg = "userId"
    val routeWithArgs = "$route/{$userIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UserEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    UserEntryBody(
        userUiState = viewModel.userUiState,
        onUserValueChange = viewModel::updateUiState,
        onSaveClick = {
            coroutineScope.launch {
                viewModel.updateItem()
                navigateBack()
            }
        },
        modifier = Modifier.padding()
    )
}

