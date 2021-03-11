package com.example.mykoinapplication.ui.main

import com.example.mykoinapplication.network.ApiInterface
import com.example.mykoinapplication.ui.main.model.UserModel

class HomeRepository(private val api:ApiInterface):IHomeRepo{
    override suspend fun getDataFromService() = api.getUser()

}