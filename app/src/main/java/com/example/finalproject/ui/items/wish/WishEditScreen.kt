package com.example.finalproject.ui.items.wish

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.InventoryTopAppBar
import com.example.finalproject.R
import com.example.finalproject.ui.AppViewModelProvider
import com.example.finalproject.ui.items.item.ItemEditDestination
import com.example.finalproject.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

object WishEditDestination : NavigationDestination {
    override val route = "wish_edit"
    override val titleRes = R.string.edit_wish_title
    const val wishIdArg = "wishId"
    val routeWithArgs = "$route/{$wishIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    navigateSettings: () ->Unit,
    viewModel: WishEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp,
                navigateSettings = navigateSettings,
            )
        },
        modifier = modifier
    ) { innerPadding ->
        WishEntryBody(
            wishUiState = viewModel.wishUiState,
            onWishValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateItem()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
