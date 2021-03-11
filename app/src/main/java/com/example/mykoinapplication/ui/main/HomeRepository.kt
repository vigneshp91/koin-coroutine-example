package com.example.mykoinapplication.ui.main

import com.example.mykoinapplication.network.ApiInterface
import com.example.mykoinapplication.network.NetworkHelper
import com.example.mykoinapplication.network.ResultWrapper
import com.example.mykoinapplication.ui.main.model.UserModel
import kotlinx.coroutines.Dispatchers

class HomeRepository(private val api:ApiInterface):IHomeRepo{
    override suspend fun getDataFromService() = NetworkHelper.safeApiCall(Dispatchers.IO) { api.getUser() }


}