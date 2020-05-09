package com.omerkhan.groceries.ui.groceries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.omerkhan.groceries.R
import com.omerkhan.groceries.data.Grocery
import com.omerkhan.groceries.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_groceries.*

class GroceriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groceries)
        createUI()
    }

    private fun createUI(){
        val fac = InjectorUtils.provideGroceriesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, fac).get(GroceriesViewModel:: class.java)

        viewModel.getGroceries().observe(this, Observer { groceries ->
            val sb =  StringBuilder()
            groceries.forEach{grocery ->
                sb.append("$grocery\n\n")
            }
            textView_groceries.text = sb.toString()
        })

        button_add_item.setOnClickListener{
            val grocery = Grocery(editText_item.text.toString(), editText_amount.text.toString())
            viewModel.addGrocery(grocery)
            editText_amount.setText("")
            editText_item.setText("")
        }
    }
}
