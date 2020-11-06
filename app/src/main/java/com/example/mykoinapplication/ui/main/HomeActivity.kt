package com.example.mykoinapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykoinapplication.R
import com.example.mykoinapplication.ui.main.model.RecipeModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        title = "Recipe"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }

    fun openCart(cartValues:ArrayList<RecipeModel>){
        title = "Cart"
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CartFragment.newInstance(cartValues))
            .addToBackStack("cart")
            .commitAllowingStateLoss()
    }
}