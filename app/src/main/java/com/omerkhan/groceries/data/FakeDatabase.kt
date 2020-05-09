package com.omerkhan.groceries.data

class FakeDatabase private constructor() {

    var groceryDao = FakeGroceryDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}