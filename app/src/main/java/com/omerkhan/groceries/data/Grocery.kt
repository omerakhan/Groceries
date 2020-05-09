package com.omerkhan.groceries.data

data class Grocery(val groceryText:String,
                   val amount: String) {
    override fun toString(): String {
        return "$groceryText ($amount)"
    }
}