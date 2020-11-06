package com.example.mykoinapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mykoinapplication.network.ResultWrapper
import com.example.mykoinapplication.ui.main.model.RecipeModel

class HomeViewModel(private val repo:HomeRepository) : ViewModel() {

    val recipeDate: LiveData<ResultWrapper<ArrayList<RecipeModel>>> = liveData {
        emit(repo.getDataFromService())
    }
}