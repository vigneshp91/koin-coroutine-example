package com.example.mykoinapplication.network

import com.example.mykoinapplication.ui.main.model.RecipeModel
import retrofit2.http.GET
import java.util.ArrayList

interface ApiInterface {

    @GET("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json")
    suspend fun  getRecipes(): ArrayList<RecipeModel>
}