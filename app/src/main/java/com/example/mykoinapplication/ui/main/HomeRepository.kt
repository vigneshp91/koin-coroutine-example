package com.example.mykoinapplication.ui.main

import com.example.mykoinapplication.network.ApiInterface
import com.example.mykoinapplication.network.NetworkHelper
import com.example.mykoinapplication.network.ResultWrapper
import com.example.mykoinapplication.ui.main.model.RecipeModel
import kotlinx.coroutines.Dispatchers

class HomeRepository(private val api:ApiInterface){

    suspend fun  getDataFromService():ResultWrapper<ArrayList<RecipeModel>> {
        return NetworkHelper.safeApiCall(Dispatchers.IO) { api.getRecipes() }
    }
}