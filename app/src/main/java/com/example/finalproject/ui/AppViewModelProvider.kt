package com.example.finalproject.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalproject.ItemsApplication
import com.example.finalproject.ui.home.HomeViewModel
import com.example.finalproject.ui.items.goal.GoalDetailsViewModel
import com.example.finalproject.ui.items.goal.GoalEditViewModel
import com.example.finalproject.ui.items.goal.GoalEntryViewModel
import com.example.finalproject.ui.items.item.ItemsDetailsViewModel
import com.example.finalproject.ui.items.item.ItemsEditViewModel
import com.example.finalproject.ui.items.item.ItemsEntryViewModel
import com.example.finalproject.ui.items.user.UserDetailsViewModel
import com.example.finalproject.ui.items.user.UserEditViewModel
import com.example.finalproject.ui.items.user.UserEntryViewModel
import com.example.finalproject.ui.items.wish.WishDetailsViewModel
import com.example.finalproject.ui.items.wish.WishEditViewModel
import com.example.finalproject.ui.items.wish.WishEntryViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            ItemsEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            WishEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            GoalEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            UserEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            ItemsEntryViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
           WishEntryViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
            GoalEntryViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
            UserEntryViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
            ItemsDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            WishDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            UserDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            GoalDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}

fun CreationExtras.inventoryApplication(): ItemsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ItemsApplication)
