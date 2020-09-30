package com.example.mykoinapplication.network

import com.example.mykoinapplication.ui.main.model.UserModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/users/2")
    suspend fun  getUser(): UserModel
}