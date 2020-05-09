package com.omerkhan.groceries.ui.groceries

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.omerkhan.groceries.data.GroceryRepository

class GroceriesViewModelFactory(private val groceryRepository: GroceryRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GroceriesViewModel(groceryRepository) as T
    }
}