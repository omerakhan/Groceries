package com.omerkhan.groceries.utilities

import com.omerkhan.groceries.data.FakeDatabase
import com.omerkhan.groceries.data.GroceryRepository
import com.omerkhan.groceries.ui.groceries.GroceriesViewModelFactory

object InjectorUtils {

    fun provideGroceriesViewModelFactory(): GroceriesViewModelFactory{
        val groceryRepository = GroceryRepository.getInstance(FakeDatabase.getInstance().groceryDao)
        return GroceriesViewModelFactory(groceryRepository)
    }
}