package com.omerkhan.groceries.data

class GroceryRepository private  constructor(private  val groceryDao: FakeGroceryDao){
    fun addGrocery(grocery: Grocery) {
        groceryDao.addGrocery(grocery)
    }

    fun getGroceries() = groceryDao.getGroceries()

    companion object {
        @Volatile private var instance: GroceryRepository? = null

        fun getInstance(groceryDao: FakeGroceryDao) =
            instance ?: synchronized(this) {
                instance ?: GroceryRepository(groceryDao).also { instance = it }
            }
    }
}
