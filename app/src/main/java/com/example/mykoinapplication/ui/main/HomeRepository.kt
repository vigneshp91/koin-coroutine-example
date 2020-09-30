package com.example.mykoinapplication.ui.main

import com.example.mykoinapplication.network.ApiInterface

class HomeRepository(private val api:ApiInterface){

    suspend fun  getDataFromService() = api.getUser()
}