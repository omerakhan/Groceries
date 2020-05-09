package com.omerkhan.groceries.ui.groceries

import androidx.lifecycle.ViewModel
import com.omerkhan.groceries.data.Grocery
import com.omerkhan.groceries.data.GroceryRepository

class GroceriesViewModel(private val groceryRepository: GroceryRepository) : ViewModel() {

    fun getGroceries() = groceryRepository.getGroceries()

    fun addGrocery(grocery: Grocery) = groceryRepository.addGrocery(grocery)
}